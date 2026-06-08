import pandas as pd

df = pd.read_csv("test_data.csv")

# Print basic info:
print("=== Basic Info ===")
print(f"Total number of tests: {len(df)}")
print("\nColumn names and dtypes:")
print(df.dtypes)
print("\nFirst 5 rows:")
print(df.head(5))

# Calculate aggregate metrics:
overall_pass_rate = (df["status"] == "pass").mean() * 100
avg_duration_ms = df["duration_ms"].mean()
avg_duration_sec = df["duration_sec"].mean()
