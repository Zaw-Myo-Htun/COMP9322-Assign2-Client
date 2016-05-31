package au.edu.unsw.soacourse.model;

import java.util.ArrayList;

public class AssignReviewerRequestDTO {
	ArrayList<ArrayList<String>> assignedReviewerList=new ArrayList<ArrayList<String>>();

	public ArrayList<ArrayList<String>> getAssignedReviewerList() {
		return assignedReviewerList;
	}

	public void setAssignedReviewerList(
			ArrayList<ArrayList<String>> assignedReviewerList) {
		this.assignedReviewerList = assignedReviewerList;
	}

	
}
