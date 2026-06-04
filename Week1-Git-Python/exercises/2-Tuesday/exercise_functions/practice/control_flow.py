#if score is >= 90, grade is A else grade is F

for score in [95,85,75,55]:
    if score >= 90:
      grade = 'A'
    elif score >= 80:
      grade = 'B'
    elif score >= 70:
      grade = 'C'
    else:
      grade = 'F'

print(f"Score {score} --> Grade {grade}")

# Ternary operator
grade = "PASS" if score>=60 else "FAIL"

# score = [95,85,75,55]
# if score >= 90 grade is A
# if score >= 90 grade is B
# if score >= 90 grade is C
# else grade is F
