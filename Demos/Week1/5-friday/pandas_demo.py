import pandas as pd
# series = 1D data array
# Data frame - 2d data structure

s = pd.Series([10,20,30,40])

#print(s)

data = {
  "Name":["Ken","Jon","Audy"],
  "Age": [29,28,29],
  "Marks": [86,87, 85]
}

df = pd.DataFrame(data)
#print(df)
# print(df.info())

# print(df[["Name","Marks"]])

high_marks = df[df["Marks"]> 85]
# print(high_marks)

df["Passed"] = df["Marks"]>=50
print(df)