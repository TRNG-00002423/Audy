def grade_processor():
  scores = [88, 92, 75, -1, 63, 95, 81, 70, -5, 55, 100, 78, -999, 90, 85]

  valid_scores = []
  distribution = {"A": 0, "B": 0, "C": 0, "D": 0, "F": 0}

  for i, s in enumerate(scores):  
    if s == -999:
      print(f"Index {i}: {s} sentinel value -- stop processing")
      break

    if s < 0:
      print(f"Index {i}: skipping negative score {s}, invalid data")
      continue

    # assign grade for valid score
    if s >= 90:
      grade = "A"
    elif s >= 80:
      grade = "B"
    elif s >= 70:
      grade = "C"
    elif s >= 60:
      grade = "D"
    else:
      grade = "F"

    valid_scores.append(s)
    distribution[grade] += 1
    print(f"Index {i}: Score {s} --> Grade {grade}")

  # summary stats
  print(f"\nClass average : {sum(valid_scores) / len(valid_scores):.2f}")
  print(f"Highest grade : {max(valid_scores)}")
  print(f"Lowest grade  : {min(valid_scores)}")
  print(f"Distribution  : {distribution}")

if __name__ == "__main__":
  grade_processor()