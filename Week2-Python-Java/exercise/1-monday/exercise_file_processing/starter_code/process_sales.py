"""
Week 2 Exercise — CSV processing with context managers.

TODO:
1. Read starter_code/data/sales.csv using csv.DictReader and with open(...).
2. Compute rows count, grand total (sum of units * unit_price), average line revenue.
3. Find SKU with max line revenue (tie: first in file).
4. Write output/summary.txt using with open(..., "w", encoding="utf-8").
"""

from __future__ import annotations
import csv
import sys
from pathlib import Path


def main() -> None:
    base = Path("data")
    sales_data_file = base / "sales.csv"
    # print(sales_data_file.suffix)

    row_count = 0
    grand_total = 0.0
    top_sku = None
    top_line_revenue = 0.0
    bad_count = 0

    with open(sales_data_file, "r", encoding="utf-8", newline="") as csv_file:
        reader = csv.DictReader(csv_file)

        for row in reader:
            try:
                units = int(row["units"])
                unit_price = float(row["unit_price"])
                line_revenue = units * unit_price

                row_count += 1
                grand_total += line_revenue

                if line_revenue > top_line_revenue:
                    top_sku = row["sku"]
                    top_line_revenue = line_revenue

            except ValueError:
                bad_count += 1
                continue

    if bad_count > 0:
        print(f"Skipped: {bad_count} bad row(s)", file=sys.stderr)

    average_line_revenue = grand_total / row_count

 


if __name__ == "__main__":
    main()            