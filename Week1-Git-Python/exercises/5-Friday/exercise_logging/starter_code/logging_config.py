"""
Configure logging for the QA Test Framework.

Requirements:
1. Console handler: Show INFO and above, concise format
2. File handler: Capture DEBUG and above, detailed format with timestamps
3. Use a RotatingFileHandler (max 1MB, keep 3 backups)
"""

import logging
from logging.handlers import RotatingFileHandler


def setup_logging(log_file="test_framework.log", console_level=logging.INFO):
    """Configure and return the root logger for the framework.

    Args:
        log_file: Path to the log file
        console_level: Minimum level for console output

    Returns:
        logging.Logger configured with both handlers
    """
    # TODO: Create logger named "qa_framework"
    qa_framework = logging.getLogger("qa_framework")
    qa_framework.setLevel(logging.DEBUG)
    # TODO: Add StreamHandler for console (INFO+)
    console = logging.StreamHandler()
    console.setLevel(console_level)
    console.setFormatter(logging.Formatter("%(asctime)s | %(levelname) -8s | %(message)s"))
    # TODO: Add RotatingFileHandler for file (DEBUG+)
    h = RotatingFileHandler(
        log_file,
        maxBytes=1_048_576,   # 1 MB
        backupCount=3
    )
    h.setLevel(logging.DEBUG)
    # TODO: Set appropriate formatters on each handler
    h.setFormatter(logging.Formatter(
        "%(asctime)s | %(levelname)-8s | %(name)s:%(lineno)d | %(message)s"
      )
    )

     # attaching both handlers to the logger
    qa_framework.addHandler(console)
    qa_framework.addHandler(h)

    # TODO: Return the configured logger
    return qa_framework