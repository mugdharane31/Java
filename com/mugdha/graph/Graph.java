package com.mugdha.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
	
	private Map<Vertex, List<Vertex>> adjVertices;
	
	public Graph() {
        this.adjVertices = new HashMap<Vertex, List<Vertex>>();
    }
	
	List<Vertex> getAdjVertices(String label) {
	    return adjVertices.get(new Vertex(label));
	}
	
	//add vertex
	public void addVertex(String label) {
		adjVertices.putIfAbsent(new Vertex(label), new ArrayList<Vertex>());
	}
	
	//remove vertex
	public void removeVertex(String label) {
		Vertex remVertex = new Vertex(label);
		adjVertices.values().stream().forEach(e -> e.remove(remVertex));
	}
	
	//add edge
	public void addEdge(String label1, String label2) {
		Vertex v1 = new Vertex(label1);
		Vertex v2 = new Vertex(label2);
		adjVertices.get(v1).add(v2);
		adjVertices.get(v2).add(v1);
	}
	
	//remove egde
	public void removeEdge(String label1, String label2) {
		Vertex v1 = new Vertex(label1);
		Vertex v2 = new Vertex(label2);
		List<Vertex> edge1 = adjVertices.get(v1);
		List<Vertex> edge2 = adjVertices.get(v2);
		if(edge1 != null) {
			adjVertices.remove(v1);
		}
		if(edge2 != null) {
			adjVertices.remove(v2);
		}
		
	}
	public Map<Vertex, List<Vertex>> getAdjVertices() {
		return adjVertices;
	}

	public void setAdjVertices(Map<Vertex, List<Vertex>> adjVertices) {
		this.adjVertices = adjVertices;
	}
	
	class Vertex {
        String label;
        Vertex(String label) {
            this.label = label;
        }
        
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + getOuterType().hashCode();
            result = prime * result + ((label == null) ? 0 : label.hashCode());
            return result;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Vertex other = (Vertex) obj;
            if (!getOuterType().equals(other.getOuterType()))
                return false;
            if (label == null) {
                if (other.label != null)
                    return false;
            } else if (!label.equals(other.label))
                return false;
            return true;
        }

        @Override
        public String toString() {
            return label;
        }


        private Graph getOuterType() {
            return Graph.this;
        }
    }
	
}
