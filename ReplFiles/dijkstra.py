# create a dictionary to represent the graph
graph = {
  'a':{'b':3,'c':4,'d':7},
  'b':{'c':1,'f':5},
  'c':{'f':6,'d':2},
  'd':{'e':3,'g':6},
  'e':{'g':3,'h':4},
  'f':{'e':1,'h':8},
  'g':{'h':2},
  'h':{'g':2},
}

def dijkstra(graph,start,goal):
  shortest_distance = {}
  track_predecessor = {}
  unseen_nodes = graph
  infinity = 999999999
  track_path = []

  for node in unseen_nodes:
      shortest_distance[node] = infinity
  shortest_distance[start] = 0

  while unseen_nodes:
    min_distance_node = None
    
    for node in unseen_nodes: 
      if min_distance_node is None:
        min_distance_node = node
      elif shortest_distance[node] < shortest_distance[min_distance_node]:
          min_distance_node = node

    path_options = graph[min_distance_node].items()

    for child_node, weight in path_options:
        if weight + shortest_distance[min_distance_node] < shortest_distance[child_node]:
          shortest_distance[child_node] = weight + shortest_distance[min_distance_node]
          track_predecessor[child_node] = min_distance_node
    unseen_nodes.pop(min_distance_node)


  current_node = goal

  while current_node != start:
    try:
        track_path.insert(0, current_node)
        current_node = track_predecessor[current_node]
    except KeyError:
      print("Path is not reachable")
      break
  track_path.insert(0, start)

  if shortest_distance[goal] != infinity:
    print("Shortest distance is " + str(shortest_distance[goal]))
    print("Optimal path is " +str(track_path))


dijkstra(graph,'a','h')

