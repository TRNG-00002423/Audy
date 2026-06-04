"""
Main Program — Product Inventory System
Week 1, Thursday | Pair Programming Exercise

Wire everything together here. Complete each numbered section.
Run with:  python main.py

References:
    written/4-Thursday/lists.md
    written/4-Thursday/tuples.md
    written/4-Thursday/sets.md
    written/4-Thursday/exception-handling-custom-exceptions.md
    written/4-Thursday/try-except.md
"""

from product import Product
from inventory import Inventory
from exceptions import ProductNotFoundError, InsufficientStockError


def section(title: str) -> None:
    print(f"\n{'─' * 55}")
    print(f"  {title}")
    print(f"{'─' * 55}")


def main():
    inv = Inventory()

    # ── 1. Add at least 8 products across 3+ categories ───────────────────
    section("1. Loading Inventory")

    # TODO: Create and add at least 8 Product instances.
    # Use at least 3 different categories (e.g., "electronics", "accessories", "software").
    # Example:
    #   p = Product("Laptop", 999.99, stock=15, category="electronics")
    #   product_id = inv.add_product(p)
    #   print(f"  Added: {p} → ID={product_id}")
    products = [
        Product("Laptop Pro", 1299.99, stock=10, category="electronics"),
        Product("Mouse", 29.99, stock=50, category="electronics"),
        Product("Keyboard", 79.99, stock=25, category="electronics"),
        Product("Monitor", 249.99, stock=12, category="electronics"),
        Product("USB Hub", 24.99, stock=40, category="accessories"),
        Product("Webcam Pro", 89.99, stock=15, category="accessories"),
        Product("Photo Editor Pro", 59.99, stock=20, category="software"),
        Product("Antivirus Plus", 39.99, stock=30, category="software"),
    ]

    for product in products:
        product_id = inv.add_product(product)
        print(f"Added: {product} -> ID={product_id}")


    # ── 2. Display all products sorted by price ────────────────────────────
    section("2. All Products (sorted by price)")

    # TODO: Use sorted() with the __lt__ dunder to sort inv.products.values().
    # Print each product using its __str__ representation.
    for product in sorted(inv.products.values()):
        print(product)

    # ── 3. Search products by keyword ─────────────────────────────────────
    section("3. Search: 'pro'")

    # TODO: Call inv.search("pro") and print the results.
    # This uses the __contains__ dunder on Product.
    for product in inv.search("pro"):
        print(product)

    # ── 4. Filter by category ─────────────────────────────────────────────
    section("4. Category: 'electronics'")

    # TODO: Call inv.by_category("electronics") and print the results.
    for product in inv.by_category("electronics"):
        print(product)

    # ── 5. Sell products — one should succeed, one should fail ────────────
    section("5. Sell Operations")

    # TODO: Attempt to sell a quantity that succeeds, then one that exceeds stock.
    # Use try/except to catch InsufficientStockError and print the error details.
    # Access e.requested and e.available from the exception object.
    try:
        inv.sell(1, 2)
        print("Sold 2 units of product ID 1 successfully.")
    except InsufficientStockError as e:
        print(f"Sale failed: requested={e.requested}, available={e.available}")

    try:
        inv.sell(1, 100)
        print("Sold 100 units of product ID 1 successfully.")
    except InsufficientStockError as e:
        print(f"Sale failed: requested={e.requested}, available={e.available}")

    # ── 6. Access a non-existent product ID ───────────────────────────────
    section("6. Non-Existent Product Lookup")

    # TODO: Try inv.get_product(9999) and catch ProductNotFoundError.
    try:
        print(inv.get_product(9999))
    except ProductNotFoundError as e:
        print(e)

    # ── 7. Transaction history ────────────────────────────────────────────
    section("7. Recent Transaction History")

    # TODO: Print each entry in inv.history.
    # Remember: history is a deque — you can iterate over it directly.
    for entry in inv.history:
        print(entry)

    # ── 8. Inventory summary ──────────────────────────────────────────────
    section("8. Inventory Summary")

    # TODO: Call inv.summary() and print each key-value pair neatly.
    summary = inv.summary()
    for key, value in summary.items():
        print(f"  {key}: {value}")

    # ── 9. Set operations on categories ───────────────────────────────────
    section("9. Set Operations on Categories")

    my_wishlist = {"electronics", "gaming", "software"}

    # TODO: Use inv.categories (a set) and my_wishlist to show:
    #   - Union:        All categories across both sets
    #   - Intersection: Categories in BOTH my_wishlist and the inventory
    #   - Difference:   Categories in my_wishlist but NOT in the inventory
    # Use the |, &, - operators (ref: written/4-Thursday/sets.md)
    print("Union:", inv.categories | my_wishlist)
    print("Intersection:", inv.categories & my_wishlist)
    print("Difference:", my_wishlist - inv.categories)

    # ── 10. Tuple-based product configurations ────────────────────────────
    section("10. Product Configs as Tuples")

    # TODO: Define at least 3 product configurations as tuples:
    #   configs = [
    #       ("Monitor", 349.99, 8, "electronics"),
    #       ("USB Hub",  24.99, 30, "accessories"),
    #       ...
    #   ]
    # Iterate over configs and add each as a Product to the inventory.
    # Print the updated total using len(inv).
    # This demonstrates tuples as immutable, structured data records.
    # (ref: written/4-Thursday/tuples.md — "Tuples as Fixed Records")
    configs = [
        ("Desk Lamp", 34.99, 18, "home"),
        ("Gaming Chair", 199.99, 6, "furniture"),
        ("USB Microphone", 119.99, 10, "accessories"),
    ]

    for name, price, stock, category in configs:
        inv.add_product(Product(name, price, stock, category))

    print(f"Updated inventory count: {len(inv)}")

    # ── 11. Edge Cases and Exception Tests ────────────────────────────────
    section("11. Edge Cases and Exception Tests")

    # 1. Sell exactly all remaining stock
    exact_product = Product("Exact Stock Item", 10.00, stock=3, category="test")
    exact_id = inv.add_product(exact_product)
    inv.sell(exact_id, 3)
    print(f"After exact sell, stock = {inv.get_product(exact_id).stock}")  
    print(f"In stock? {bool(inv.get_product(exact_id))}")              

    # 2. Remove a product and try to sell it
    removed_product = Product("Temporary Item", 15.00, stock=5, category="test")
    removed_id = inv.add_product(removed_product)
    inv.remove_product(removed_id)

    try:
        inv.sell(removed_id, 1)
    except ProductNotFoundError as e:
        print(f"Sell after remove: {e}")

    # 3. Add duplicate products
    dup1 = Product("Mouse", 25.00, stock=10, category="electronics")
    dup2 = Product("Mouse", 30.00, stock=8, category="electronics")

    dup1_id = inv.add_product(dup1)
    dup2_id = inv.add_product(dup2)

    print(f"Duplicate IDs: {dup1_id}, {dup2_id}")
    print(f"dup1 == dup2: {dup1 == dup2}")
    print(f"Total products in inventory: {len(inv)}")

    # 4. Extra ProductNotFoundError tests
    try:
        inv.get_product(5000)
    except ProductNotFoundError as e:
        print(f"Missing get_product: {e}")

    try:
        inv.remove_product(6000)
    except ProductNotFoundError as e:
        print(f"Missing remove_product: {e}")

    try:
        inv.sell(7000, 1)
    except ProductNotFoundError as e:
        print(f"Missing sell: {e}")

    # 5. Extra InsufficientStockError tests
    low_stock = Product("Low Stock Item", 12.50, stock=2, category="test")
    low_stock_id = inv.add_product(low_stock)

    try:
        inv.sell(low_stock_id, 3)
    except InsufficientStockError as e:
        print(f"Too many requested: requested={e.requested}, available={e.available}")

    zero_stock = Product("Zero Stock Item", 5.00, stock=0, category="test")
    zero_stock_id = inv.add_product(zero_stock)

    try:
        inv.sell(zero_stock_id, 1)
    except InsufficientStockError as e:
        print(f"Sell from zero stock: requested={e.requested}, available={e.available}")

if __name__ == "__main__":
    main()
