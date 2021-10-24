#import csv

with open('play.csv', 'r') as play:
  next(play)
  for line in play:
    data_row = line.split(',')
    print(data_row)

import pandas as pd
data = pd.read_csv(r'play.csv')
print(data)

import csv
with open('play.csv','rt')as play:
  data = csv.reader(play)
  for line in data:
    print(line)
