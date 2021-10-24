# no more than 8 pawns b & w 
# no more than 1 queen, king w & b
# no more than 2 knights,rooks, and bishops w & b

def isValidChessBoard(board):
  numwKing = findCount('wKing', board)
  numbKing = findCount('bKing', board)
  numwQueen = findCount('wQueen', board)
  numbQueen = findCount('bQueen', board)
  numwKnight = findCount('wKnight', board)
  numbKnight = findCount('bKnight', board)
  numwRook = findCount('wRook', board)
  numbRook = findCount('bRook', board)
  numwBishop = findCount('wBishop', board)
  numbBishop = findCount('bBishop', board)
  numwPawn = findCount('wPawn', board)
  numbPawn = findCount('bPawn', board)
  
  isValid = True;
  if(numwKing != 1 or numbKing != 1):
    isValid = False;
  if(numwQueen > 1 or numbQueen > 1):
    isValid = False;
  if(numwKnight > 2 or numbKnight > 2):
    isValid = False;
  if(numwRook > 2 or numbRook > 2):
    isValid = False;
  if(numwBishop > 2 or numbBishop > 2):
    isValid = False;
  if(numwPawn > 8 or numbPawn > 8):
    isValid = False;

  return isValid

def findCount(piece, board):
  count = 0
  for item in board.values():
    if item == piece:
      count += 1
  return count

board = \
{'1h': 'bKing', 
'6c': 'wQueen',
'2g': 'bBishop', 
'5h': 'bQueen', 
'3e': 'wKing'}
print(isValidChessBoard(board))

board = \
{'1h': 'bKing', 
'2d': 'bKing',
'6c': 'wQueen',
'2g': 'bBishop', 
'5h': 'bQueen', 
'3e': 'wKing'}
print(isValidChessBoard(board))
