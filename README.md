# Java Supermarket Simulation

A collaborative Collin College Programming Fundamentals III project modeling supermarket operations through Java console demos.

## Team and contributions

Created by **Josh Fletcher, Josiah English, and Zaid N. M. Abusamra**, as credited in the original source files. Zaid reports that all team members collaborated across the project. This portfolio copy preserves the submitted Java source and its author credits; it does not assign individual ownership of particular components.

## What the code demonstrates

- Cash-register transactions, price lookup, tax calculations, and printed receipts.
- Smart shelves, inventory access, and custom exceptions.
- Generic shelf interfaces and multiple product types.
- Item-specific promotions, best-discount selection, and expiration handling.
- A custom array-backed stack for shopping carts.
- A custom linked list and iterator for shopping lists.

## Technologies

Java, object-oriented programming, interfaces, generics, collections, stacks, linked lists, iterators, exceptions, and text-resource loading. The original Eclipse project targets Java 21. No external libraries are required.

## Run on Windows

Install a JDK supporting Java 21 or later, open PowerShell in this folder, and run:

```powershell
$sources = Get-ChildItem -Path src -Recurse -Filter *.java | ForEach-Object { $_.FullName }
New-Item -ItemType Directory -Force build | Out-Null
javac -encoding UTF-8 --release 21 -d build $sources
java -cp "build;resources" edu.collin.cosc2436.team4.cashregister.CashRegisterDemo
```

For the promotions demo:

```powershell
java -cp "build;resources" edu.collin.cosc2436.team4.promotions.PromotionDemo
```

On macOS/Linux, compile with `find src -name '*.java' > sources.txt` followed by `javac -encoding UTF-8 --release 21 -d build @sources.txt`, and use `build:resources` as the runtime classpath.

Alternatively, import the existing project into Eclipse. The `resources` folder must be on the runtime classpath.

## Other demo entry points

All classes below are under `edu.collin.cosc2436.team4`:

| Module | Entry point |
| --- | --- |
| Original register | `cashregister.CashRegisterDemo` |
| Revised register | `cashregisterrevisited.CashRegisterDemo` |
| Smart shelf | `smartshelf.SmartShelfDemo` |
| Generic smart shelf | `genericsmartshelf.SmartShelfDemo` |
| Promotions | `promotions.PromotionDemo` |
| Shopping list | `shoppinglist.ShoppingListDemo` |

The shopping-cart package supplies supporting classes and has no standalone main method.

## Sample receipt

```text
CHIPS $ 2.49
CEREAL $ 3.25

Subtotal $ 5.74
Tax $ 0.00
Total $ 5.74
```

## Verification and limitations

All Java sources were compiled with JDK 26.0.1 using `--release 21`. The cash-register and promotions demos completed successfully. Their output is included in `docs/`. This is a compile and demo check, not a comprehensive automated test suite. Other demos have not been execution-tested for this portfolio preparation.

PromotionDemo uses fixed dates in February-May 2026 and the current date for removing expired promotions, so its later output varies with the run date. The supplied code does not demonstrate a military-specific 25% discount. The project is a collection of educational console modules, with no web interface or persistent database.

## Portfolio preparation

The portfolio preparation added this README, a .gitignore, and captured demo output. Original Java code and data files were preserved. Compiled class files from the submitted archive were excluded.
