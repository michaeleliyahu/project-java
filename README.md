# readme
Over the last few weeks we have created a project that deals with Graph algorithms. Now, I will briefly elaborate and write key content of the project.

# Main classes:
1. DGraph
2. Edge
3. Graph_Algo
4. Graph_GUI
5. Node
In the following lines, I will explain which cases are valid and elaborate on the abnormal cases in some functions. 

# DGraph class: 
This class is an implements represents a directional weighted graph. The class has a road-system or communication network in mind - and should support a large number of nodes (over 100,000).


List of functions:
node_data getNode, edge_data getEdge, addNode, connect, Collection, node_data removeNode, edge_data removeEdge, nodeSize, edgeSize, getMC

 
# Edge class:
This class is an implements represents the set of operations applicable on a directional edge(src,dest) in a (directional) weighted graph.


List of functions:
Edge, getSrc, getDest, getWeight, String getInfo, setInfo, getTag, setTag.


# Graph_Algo class:
This class is an implements represents the "regular" Graph Theory algorithms.

List of functions:
init,cleanGraf, save, isConnected, shortestPathDist, shortestPath, TSP, copy




# Graph_GUI class: 
The class's purpose is to create the graph. we used in Jframe class.


List of functions:
Window, initGUI, paint, actionPerformed.


# Node class: 
This class is an implements represents the set of operations applicable on a node (vertex) in a (directional) weighted graph.


List of functions:
getKey, Point3D getLocation, setLocation, getWeight, setWeight, String getInfo, setInfo, getTag, setTag.









