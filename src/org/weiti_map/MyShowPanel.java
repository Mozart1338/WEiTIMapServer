package org.weiti_map;

import javax.swing.JPanel;

import net.miginfocom.layout.LC;
import net.miginfocom.swing.MigLayout;

public class MyShowPanel extends JPanel {	

	private static final long serialVersionUID = 1L;	
			
	public enum SHOW_PANEL_TYPES {GROUP_TABLES, WORKERS_TABLE, ROOMS_TABLE, LECTURES_TABLE};
	private SHOW_PANEL_TYPES panel_type;
	
	private MyDatabase mDatabase;
	private PlanTablePanel tablePanelP;
	private PlanTablePanel tablePanelN;
	private RoomsTablePanel roomsTable;
//	private WorkersTablePanel workersTable;
	
	   MyShowPanel(MyDatabase mDB, SHOW_PANEL_TYPES type) {
			super();			
			mDatabase = mDB;
			panel_type = type;			

			LC layoutConstraints = new LC();
			layoutConstraints.setFillX(true);
			setLayout(new MigLayout(layoutConstraints));
			
			switch (panel_type) {
			case GROUP_TABLES:
				tablePanelP = new PlanTablePanel('P');
				tablePanelN = new PlanTablePanel('N');	
				add(tablePanelP);
				add(tablePanelN);
				break;
			case WORKERS_TABLE:				
				break;
			case ROOMS_TABLE:
				roomsTable = new RoomsTablePanel(mDatabase.getRoomsTableObject());				
				add(roomsTable);
				break;
			case LECTURES_TABLE:
				break;
			}		
	   }	   	   	   

	    void setGroupPlanObject(GroupPlanObject plan) {	    	
	    	if (panel_type == SHOW_PANEL_TYPES.GROUP_TABLES) {
	    		tablePanelP.setGroupPlan(plan);
    	    	tablePanelN.setGroupPlan(plan);
	    	} else {
	    		System.out.println("BAD SHOW PANEL TYPE");
	    		return;
	    	}
	    	
	    }

		void resetTable() {
			tablePanelP.resetTable();
	    	tablePanelN.resetTable();  			
		}
	    
		SHOW_PANEL_TYPES getPanelType() {
			return panel_type; 
		}

		public void showWorkersTable(WorkersTableObject table) {
			// TODO Auto-generated method stub			
		}

		public void showRoomsTable(RoomsTableObject table) {
			// TODO Auto-generated method stub			
		}
}
