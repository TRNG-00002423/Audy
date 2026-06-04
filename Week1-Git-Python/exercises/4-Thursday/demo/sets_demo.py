# Sets : Mutable, unordered, unique

ids = {1,2,3,4,5}

empty_set = set()

nums = {1,2,2,3,4,5,3}

from_list = set([10,20,20,30]) # creating a set from a list

ids = {1,2,3}
ids.add(4)
ids.add(2)

ids.remove(1)
ids.remove(100) # error

ids.discard(2)
ids.discard(100) # no error

val = ids.pop() # removes an arbitary number in set

ids.clear() # clears or removes all elements

fruits = {"apple","banana", "mango", "carrot"}
veges = {"cabbage","carrot", "lettuce"}

frutis_and_vegs = fruits.union(veges) # union

# Intersection

