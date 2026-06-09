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
from datetime import datetime



def main() -> None:
    
    sales_data_file = Path(__file__).parent / "data" / "sales.csv" #path relavtive to to this script (starter_code/)
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

    # output/summary.txt is relative to this file (starter_code/)
    report_path = Path(__file__).parent / "output" / "summary.txt"
    report_path.parent.mkdir(parents=True, exist_ok=True)

    with open(report_path, "w", encoding="utf-8") as f:
        f.write(f"Sales Summary Report — {datetime.now()}\n")
        f.write("=" * 40 + "\n")
        f.write(f"rows={row_count}\n")
        f.write(f"grand_total={grand_total:.2f}\n")
        f.write(f"average_line_revenue={average_line_revenue:.2f}\n")
        f.write(f"top_sku={top_sku}\n")
        f.write(f"top_line_revenue={top_line_revenue:.2f}\n")
        f.write("=" * 40 + "\n")


if __name__ == "__main__":
    main()            