import time
from functools import wraps

# ── Task 5: Timer Decorator ─────────────────────────────────────────────────────────────

def timer(func):
    """Decorator that measures and prints execution time.

    Output format: "⏱️ {func_name} completed in {seconds:.4f}s"
    """
    # TODO: Implement
    @wraps(func)
    def wrapper(*args, **kwargs):
        start_time = time.time()
        result = func(*args, **kwargs)
        end_time = time.time()
        seconds = end_time - start_time
        print(f"⏱️ {func.__name__} completed in {seconds:.4f}s")
        return result
    return wrapper

# testing timer function
@timer
def slow_operation():
    time.sleep(0.5)
    return "done"

result = slow_operation()
# Should print: ⏱️ slow_operation completed in 0.50XXs
assert result == "done"
assert slow_operation.__name__ == "slow_operation"  # @wraps preserves metadata


# ── Task 6: Retry Decorator with Parameters ──────────────────────────────────────────────
def retry(max_attempts=3, delay=0.5, exceptions=(Exception,)):
    """Parameterized decorator that retries on failure.

    Args:
        max_attempts: Maximum number of tries
        delay: Seconds between retries
        exceptions: Tuple of exception types to catch

    Prints progress: "⚠️ Attempt {n}/{max}: {error}. Retrying in {delay}s..."
    On final failure: "💥 {func_name} failed after {max} attempts"
    """
    # TODO: Implement (3-layer nesting: factory → decorator → wrapper)
    def decorator(func):
        @wraps(func)
        def wrapper(*args, **kwargs):
            for attempt in range(1, max_attempts + 1):
                try:
                    return func(*args, **kwargs)
                except exceptions as e:
                    if attempt == max_attempts:
                      print(f"💥 {func.name} failed after {max_attempts} attempts")
                      raise
                    print(f"Attempt {attempt}/{max_attempts}: {e}. Retrying in {delay}s..")
                    time.sleep(delay)
        return wrapper
    return decorator
                    

attempt_count = 0

@retry(max_attempts=3, delay=0.1)
def flaky_function():
    global attempt_count
    attempt_count += 1
    if attempt_count < 3:
        raise ConnectionError("Server unavailable")
    return "success"

result = flaky_function()
assert result == "success"


# ── Task 7: Call Logger Decorator ──────────────────────────────────────────────
def log_calls(func):
    """Decorator that logs function calls with arguments and return value.

    Output:
        "📞 Calling func_name(arg1, arg2, key=val)"
        "✅ func_name → return_value"
    """
    # TODO
    @wraps(func)
    def wrapper(*args, **kwargs):
        parts = [str(arg) for arg in args]
        parts += [f"{key}={value}" for key, value in kwargs.items()]
        print(f"📞 Calling {func.__name__}({', '.join(parts)})")
        result = func(*args, **kwargs)
        print(f"✅ {func.__name__} → {result}")
        return result
    return wrapper


# ── Task 8: Stack Decorators ──────────────────────────────────────────────
# executes in the order of: timer -> log_calls -> retry -> process_data
@timer
@log_calls
@retry(max_attempts=2, delay=0.1)
def process_data(data):
    """Process data with timing, logging, and retry."""
    if not data:
        raise ValueError("Empty data")
    return [x * 2 for x in data]

result = process_data([1, 2, 3])