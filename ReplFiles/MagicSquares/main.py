#Read in a csv file and determine if the data is a magic square or not.  Sample files are provided for you to use to test with.

import numpy as np

#Vertical
def rows(square, magicNum):
  n = len(square)
  for i in range(n):
    sumRow = 0
    for j in range(n):
      sumRow += square[i][j]
    if sumRow != magicNum:
      return False
  return True

#Horizontal
def cols(square, magicNum):
  n = len(square)
  for i in range(n):
    sumRow = 0
    for j in range(n):
      sumRow += square[j][i]
    if sumRow != magicNum:
      return False
  return True
      
#Diagonal
def diagonals(square, magicNum):
  #Left to Right
  sDiag = 0
  for n in range(len(square)):
    sDiag += square[n][n]
  if sDiag != magicNum:
    return False
    
  #Right to Left
  sdiag = 0
  for n in range(len(square)):
    sdiag += square[len(square)-n-1][len(square)-n-1]
  if sdiag != magicNum:
    return False
  return True


yes3x3 = open("MagicSquare3X3.csv")
testA = np.loadtxt(yes3x3, delimiter=",")
print(rows(testA, 15))
print(cols(testA, 15))
print(diagonals(testA, 15))
print()

no3x3 = open("NonMagicSquare3X3.csv")
testB = np.loadtxt(no3x3, delimiter=",")
print(rows(testB, 15))
print(cols(testB, 15))
print(diagonals(testB, 15))
print()

yes4x4 = open("MagicSquare4X4.csv")
testC = np.loadtxt(yes4x4, delimiter=",")
print(rows(testC, 34))
print(cols(testC, 34))
print(diagonals(testC, 34))
print()

no4x4 = open("NonMagicSquare4X4.csv")
testD = np.loadtxt(no4x4, delimiter=",")
print(rows(testD, 34))
print(cols(testD, 34))
print(diagonals(testD, 34))
print()

yes5x5 = open("MagicSquare5X5.csv")
testE = np.loadtxt(yes5x5, delimiter=",")
print(rows(testE, 65))
print(cols(testE, 65))
print(diagonals(testE, 65))
print()

no5x5 = open("NonMagicSquare5X5.csv")
testF = np.loadtxt(no5x5, delimiter=",")
print(rows(testF, 65))
print(cols(testF, 65))
print(diagonals(testF, 65))
print()
