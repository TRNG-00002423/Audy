# Comprehensions are pythonic way to transform and filter data
num = [1,2,3,4,5,6,7,8,9]
# calculate squares of num from 1 to 9
for num in range(10):
  sq = num ** 2
  print(sq)

squares = [ x**2 for x in range(10)]

even_sq = [ x **2 for x in range(10) if x % 2 == 0]

names = ["alice", "bob", "charlie"]
# {'Alice': 5, 'Bob':3, 'Charlie:7'}

name_len = {name:len(name) for name in names}