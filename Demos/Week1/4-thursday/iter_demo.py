nums = [1,2,3,4,5] # list -- iterable

for num in nums:
  print(num)

# next(nums)
print("-------")
my_itr = iter(nums)

print(next(my_itr))
print(next(my_itr))