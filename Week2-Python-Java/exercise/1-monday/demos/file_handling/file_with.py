import pickle

nums = [1,2,3,4,5,6,7]

with open("num_pick.dat","wb") as file:
  pickle.dump(nums, file)
  # no need to close

with open("num_pick.dat","rb") as file:
  data = pickle.load(file)
  # no need to close as we are using the context manager, "with" statement