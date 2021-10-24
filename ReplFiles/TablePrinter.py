tableData = [['apples', 'oranges', 'cherries', 'banana'], ['Alice', 'Bob', 'Carol', 'David'], ['dogs', 'cats', 'moose', 'goose']]

def printTable(tableData):
  colWidths = [0] * len(tableData)
  for r in range(len(tableData)):
    colWidths[r] = len(tableData[r][0])
    for c in range(len(tableData[0])):
      if len(tableData[r][c]) > colWidths[r]:
        colWidths[r] = len(tableData[r][c])

  for c in range(len(tableData[0])):
    for r in range(len(tableData)):
      for x in range((colWidths[r])-len(tableData[r][c])):
        print(' ', end= '')
      print(tableData[r][c], end=' ') 
    print('')

printTable(tableData)
