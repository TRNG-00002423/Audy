"""
QA Test Metrics Calculator
Fill in the code below where you see # TODO comments.
"""

def main():
    print("═" * 40)
    print("  QA Test Metrics Calculator")
    print("═" * 40)

    # TODO 1: Get user input
    # - Total test cases (convert to int)
    # - Passed tests (convert to int)
    # - Total execution time in seconds (convert to float)
    total_tests = int(input("Enter the total number of test cases: "))
    passed_tests = int(input("Enter the number of passed tests: "))
    total_time = float(input("Enter the total execution time in seconds: "))

    # TODO 2: Calculate metrics
    # - failed tests
    # - pass rate (as percentage)
    # - fail rate (as percentage)
    # - average time per test
    failed_tests = total_tests - passed_tests
    pass_rate = (passed_tests / total_tests) * 100
    fail_rate = (failed_tests / total_tests) * 100
    avg_time = total_time / total_tests

    # TODO 3: Print the results summary using f-strings
    # Use the format shown in the README
    print("\nTest Metrics Summary:")
    print(f"Total tests: {total_tests}")
    print(f"Passed: {passed_tests}")
    print(f"Failed: {failed_tests}")
    print(f"Pass rate: {pass_rate: }%")
    print(f"Fail rate: {fail_rate: }%")
    print(f"Avg time/test: {avg_time: .2f}s")
    print(f"Total time: {total_time: .2f}s")

    # TODO 4: Determine and print the verdict
    # >= 95% → RELEASE APPROVED
    # >= 80% → CONDITIONAL RELEASE
    # else   → RELEASE BLOCKED
    if pass_rate >= 95:
        verdict = "RELEASE APPROVED"
    elif pass_rate >= 80:
        verdict = "CONDITIONAL RELEASE"
    else:
        verdict = "RELEASE BLOCKED"
    print(f"Verdict: {verdict} - review failures")

if __name__ == "__main__":
    main()