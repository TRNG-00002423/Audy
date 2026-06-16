# a = [1,2,3]
# b = [4,5,6]

# result = {}
# for i in range(len(a)):
#   result.append(a[i]+b[i])

# print(result)
# # result = [5,7,9]

import numpy as np

a = np.array([1,2,3])
b = np.array([4,5,6])

print (a+b)
arr = np.array([[1,2,3],
                [4,5,6]])
print(arr)

arr1 = np.array([1,2,3,4])
print(arr1*2)
print("*"*20)
print(np.square(arr1))
print("-"*20)
arr2 = np.array([1, 4, 9, 16])
print(np.sqrt(arr2))
print("-"*20)
print(np.sum(arr2))
print("-"*20)
arr3 = np.array([3,4,5,6,2,10,12,33,2,7])
print(np.max(arr3))

print("-"*20)
print(np.zeros((2,3)))
print(np.shape(arr3))
