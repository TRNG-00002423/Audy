def format_test_name(name):
    """Convert a human-readable name to a test function name.

    Example:
        format_test_name("Valid Login") → "test_valid_login"
        format_test_name("  Search Results Page  ") → "test_search_results_page"

    Rules:
        - Lowercase
        - Spaces replaced with underscores
        - Leading/trailing whitespace stripped
        - Prefixed with "test_"
    """
    test_name = name.strip().lower().replace(" ", "_")
    return "test_" + test_name


def is_valid_test_name(name):
    """Check if a string is a valid test function name.

    Rules:
        - Must start with "test_"
        - Must contain only lowercase letters, digits, and underscores
        - Must be at least 6 characters (e.g., "test_x")

    Returns: bool
    """
    if len(name) < 6:
        return False
    if name[0:5] != "test_":
        return False
    for char in name:
        if not (char.islower() or char.isdigit() or char == "_"):
            return False
    return True


# Task 2: Default Parameters
def create_test_result(name, status="pass", duration_ms=0, error=None):
    """Create a test result dictionary.

    Args:
        name: Test name (required)
        status: "pass" or "fail" (default: "pass")
        duration_ms: Execution time in ms (default: 0)
        error: Error message if failed (default: None)

    Returns:
        dict with keys: name, status, duration_ms, error
    """
    return {
        "name": name,
        "status": status,
        "duration_ms": duration_ms,
        "error": error
    }


def format_duration(ms, unit="ms"):
    """Format a duration value with the specified unit.

    Args:
        ms: Duration in milliseconds
        unit: "ms", "s", or "min" (default: "ms")

    Returns:
        Formatted string like "1,200ms" or "1.20s" or "0.02min"
    """
    if unit == "ms":
        return f"{ms:,}ms"
    elif unit == "s":
        return f"{ms / 1000:.2f}s"
    elif unit == "min":
        return f"{ms / 60000:.2f}min"


# Task 3
def calculate_stats(*scores):
    """Calculate statistics for any number of scores.

    Returns:
        dict with keys: count, total, average, min, max

    Raises:
        ValueError if no scores provided
    """
    if len(scores) == 0:
        raise ValueError
    
    return {
        "count":len(scores),
        "total": sum(scores),
        "average": sum(scores) / len(scores),
        "min": min(scores),
        "max": max(scores)
    }


def build_test_config(**settings):
    """Build a test configuration with defaults.

    Default config:
        browser: "chrome"
        headless: False
        timeout: 30
        retries: 0
        base_url: "http://localhost:3000"

    Any **settings passed override the defaults.

    Returns: dict
    """
    config = {
        "browser": "chrome",
        "headless": False,
        "timeout": 30,
        "retries": 0,
        "base_url": "http://localhost:3000"
    }

    config.update(settings)
    return config

# Task 4
def analyze_results(*results):
    """Analyze a list of test result dicts.

    Args:
        *results: test result dicts (from create_test_result)

    Returns:
        tuple of (passed_count, failed_count, pass_rate, avg_duration)
    """
    passed_count = 0
    failed_count= 0
    total_duration = 0
    
    # Gets the total count for each args
    for r in results:
        if r["status"] == "pass":
            passed_count += 1
        else:
            failed_count += 1
        total_duration += r["duration_ms"]
    
    total = passed_count + failed_count
    pass_rate = (passed_count / total) * 100
    avg_duration = total_duration / total

    # Returns the values as a tuple
    return passed_count,failed_count, pass_rate, avg_duration
    



def generate_report(*results):
    """Generate a formatted test report string.

    Calls analyze_results() internally and formats the output.

    Returns: formatted multi-line string
    """
    passed_count, failed_count, pass_rate, avg_duration = analyze_results(*results)

    lines = [
        "_____Test Report____",
        f"Total:    {passed_count + failed_count}",
        f"Passed:   {passed_count}",
        f"Failed:   {failed_count}",
        f"Pass Rate: {pass_rate:.1f}%",
        f"Avg Duration: {format_duration(int(avg_duration))}",
        "____________________"
    ]
    return "\n".join(lines)



# __Asserts__

# Test Task 1
assert format_test_name("Valid Login") == "test_valid_login"
assert format_test_name("  Search Results  ") == "test_search_results"
assert is_valid_test_name("test_login") == True
assert is_valid_test_name("login_test") == False
assert is_valid_test_name("test_") == False

# Test Task 2
r1 = create_test_result("test_login")
assert r1 == {"name": "test_login", "status": "pass", "duration_ms": 0, "error": None}

r2 = create_test_result("test_checkout", status="fail", duration_ms=2300, error="Timeout")
assert r2["status"] == "fail"
assert r2["error"] == "Timeout"

assert format_duration(1200) == "1,200ms"
assert format_duration(1200, "s") == "1.20s"

# Test Task 3
stats = calculate_stats(85, 92, 78, 95, 88)
assert stats["count"] == 5
assert stats["average"] == 87.6
assert stats["min"] == 78
assert stats["max"] == 95

config = build_test_config(headless=True, timeout=60)
assert config["browser"] == "chrome"  # default
assert config["headless"] == True     # overridden
assert config["timeout"] == 60       # overridden

# Test Task 4 
results = [
    create_test_result("test_login", "pass", 1200),
    create_test_result("test_search", "pass", 850),
    create_test_result("test_checkout", "fail", 2300, "Timeout"),
    create_test_result("test_profile", "pass", 450),
]

passed_count, failed_count, pass_rate, avg_duration = analyze_results(*results)
assert passed_count == 3
assert failed_count == 1
assert pass_rate == 75.0

def main():
    
    # Format test names
    print(format_test_name("Valid Login"))
    print(format_test_name("  Search Results  "))

    # Check if names are valid
    print(is_valid_test_name("test_login"))
    print(is_valid_test_name("login_test"))

    # Create test results
    results = [
        create_test_result("test_login", "pass", 1200),
        create_test_result("test_search", "pass", 850),
        create_test_result("test_checkout", "fail", 2300, "Timeout"),
        create_test_result("test_profile", "pass", 450),
    ]

    # Check durations
    print(format_duration(1200))
    print(format_duration(1200, "s"))

    # Calculate stats
    stats = calculate_stats(85, 92, 78, 95, 88)
    print(stats)

    # Build  config
    config = build_test_config(headless=True, timeout=60)
    print(config)

    # Print test report
    print(generate_report(*results))


main()