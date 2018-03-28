package models;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class BestFirstSearch {
    private PriorityQueue<Board> openList;
    private ArrayList<Board> visitedList;
    private Board root;
    private String solution;
	private String solutionName;

    public BestFirstSearch(){
        openList = new PriorityQueue<>();
        visitedList = new ArrayList<>();
    }

    public PriorityQueue<Board> getOpenList() {
        return openList;
    }

    public ArrayList<Board> getVisitedList() {
        return visitedList;
    }

    public Board getRoot() {
        return root;
    }

    public void setRoot(Board root) {
        this.root = root;
    }

    private void setSolution() {
        solution = null;
        if (!visitedList.isEmpty()) {
            if (visitedList.get(visitedList.size() - 1).getHeuristic5() != 0) {
                //there is no solution
                return;
            } else {
				StringBuilder solutionNameStb = new StringBuilder();
                StringBuilder solutionStb = new StringBuilder();
                Board current = visitedList.get(visitedList.size() - 1);
                while(current.getParent() != null) {
                    solutionNameStb.append(current.getNameOfEmptyToken());
                    solutionStb.append(current.getDirectionFromParent());
                    current = current.getParent();
                }
                this.solution = solutionStb.reverse().toString();
				this.solutionName = solutionNameStb.reverse().toString();
            }
        }
    }
	

    public String getSolution() {
        return solution;
    }
	
	public String getSolutionName() {
        return solutionName;
    }

    public void search(Board root){
        this.root = root;
        boolean isGoal = false;
        openList.add(this.root);

        while(!openList.isEmpty() && !isGoal){
            Board current = openList.remove();
            visitedList.add(current);
            if (current.checkGoal()){
                isGoal = true;
            }else{
                Board[] successors = current.getSucessors();
                for(Board successor: successors){
                    boolean exist = false;
                    for(Board b: visitedList)
                    {
                        if(b.equals(successor)){
                            exist = true;
                            break;
                        }
                    }
                    if (!exist) {
                        for (Board bm : openList) {
                            if (bm.equals(successor)) {
                                exist = true;
                                break;
                            }
                        }
                    }
                    if (!exist) {
                        successor.setHeuristicValue();
                        openList.add(successor);
                    }

                }
            }
        }
        this.setSolution();
    }

}
