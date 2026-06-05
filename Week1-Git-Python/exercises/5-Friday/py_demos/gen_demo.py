# sq_list = [x*x for x in range(5)] # list comprehensions
# print(sq_list)

# stores sll values in memory

# def get_numbers():
#   nums = []

#   for i in range(1,6):
#     nums.append(i)
  
#   return nums

# result = get_numbers()
# print(result)

#generators work w one value at a time
# yields doesnt return ((execution is paused))
def get_numbers():
  for i in range(1,6):
    yield i

gen = get_numbers()
print(gen)

for num in gen:
  print(num)
print("-"*20)

# generator expression (short form of func)
gen = (i for i in range(1,6))
for n in gen:
  print(n)