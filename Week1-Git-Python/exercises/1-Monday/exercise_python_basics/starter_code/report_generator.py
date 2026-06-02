
# Define 5 test results (name, duration, status)
test_login = ("test_login", 1200, True)
test_search = ("test_search", 850, True)
test_checkout = ("test_checkout", 2300, False)
test_profile = ("test_profile", 450, True)
test_logout = ("test_logout", 180, True)

test_results = [
		test_login,
		test_search,
		test_checkout,
		test_profile,
		test_logout,
	]

# Calculations for test results
total_duration = 0
passed_count = 0

for _, duration, status_pass in test_results:
		total_duration += duration
		if status_pass:
			passed_count += 1

total_count = len(test_results)

# Print formatted table using f-strings with alignment
print("┌──────────────────┬────────────┬──────────┐")
print("│ Test Name        │ Duration   │ Status   │")
print("├──────────────────┼────────────┼──────────┤")

for test_name, duration, status_pass in test_results:
		status_text = "✅ PASS" if status_pass else "❌ FAIL"
		print(f"│ {test_name:<16} │ {duration:>7,} ms │ {status_text:<8} │")

print("├──────────────────┼────────────┼──────────┤")
print(f"│ {'TOTAL':<16} │ {total_duration:>7,} ms │ {passed_count}/{total_count} Pass │")
print("└──────────────────┴────────────┴──────────┘")