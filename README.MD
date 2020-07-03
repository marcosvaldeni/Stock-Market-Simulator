
# Stock Market Simulator

> “Experience is the name everyone gives to their mistakes.” – Oscar Wilde

<br />
<p align="center"><img src=".github/home.gif?raw=true"/></p>

---

# :pushpin: Table of Contents

* [Description](#memo-description)
* [Features](#rocket-features)
* [Installation](#construction_worker-installation)
* [Getting Started](#runner-getting-started)
* [Found a bug? Missing a specific feature?](#bug-issues)
* [Contributing](#tada-contributing)
* [License](#closed_book-license)

# :memo: Description

The program  nominated Stock Market Simulator, was design to simulate both companies and investors, and  present the user a menu with a list of possible reports for them to see the result from specific input requirements:
Create dynamically 100 companies, with a random number of shares (between 500 and 1000), a random share price (between 10 and 100). 
The system create dynamically 100 investors with a random budget between 1000 and 10000.

# :rocket: Features

* 📊 Simulate a stock market.
* 📑 Automatically create reports of all simulations.
* 🗄  Store on a database all simulations.

# :construction_worker: Installation

**You need to install at least [Java 8](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html) and [MySQL 5.7](https://www.mysql.com/downloads/), I would recommend [Xampp](https://www.apachefriends.org/download.html) in order to run MySQL with phpMyAdmin, then to clone the project via HTTPS, run this command:**

```git clone https://github.com/marcosvaldeni/Stock-Market-Simulator```

SSH URLs provide access to a Git repository via SSH, a secure protocol. If you have a SSH key registered in your Github account, clone the project using this command:

```git clone git@github.com:marcosvaldeni/Stock-Market-Simulator.git```

# :runner: Getting Started

**Importing database**

To prepare the database, run the content of the file [StockMarketSimulator.sql](https://github.com/marcosvaldeni/Stock-Market-Simulator/blob/master/StockMarketSimulator.sql) on the phpMyAdmin `console`.

**Setup the credetials**

Once the program is running, it will request Database preferences: `user`, `password`, `port` and `host`.

<p align="center"><img src=".github/database.png?raw=true"/></p>

**Path for MySQL Connector**

This project requires an external java library [mysql-connector-java-8.0.12](https://dev.mysql.com/doc/relnotes/connector-j/8.0/en/news-8-0-12.html), in order to connect the project to a database.
You can just follow this [tutorial](https://github.com/marcosvaldeni/Stock-Market-Simulator/blob/master/MysqlConnectorTutorial.md).

# :bug: Issues

Feel free to **file a new issue** with a respective title and description on the the [Stock Market Simulator](https://github.com/marcosvaldeni/Stock-Market-Simulator/issues) repository. If you already found a solution to your problem, **i would love to review your pull request**! Have a look at our [contribution guidelines](https://github.com/marcosvaldeni/Stock-Market-Simulator/blob/master/CONTRIBUTING.md) to find out about the coding standards.

# :tada: Contributing

Check out the [contributing](https://github.com/marcosvaldeni/Stock-Market-Simulator/blob/master/CONTRIBUTING.md) page to see the best places to file issues, start discussions and begin contributing.

# :closed_book: License

Released in 2019.
This project is under the [MIT license](https://github.com/marcosvaldeni/Stock-Market-Simulator/blob/master/LICENSE).

Made with love by [Marcos Lucas](https://github.com/marcosvaldeni) 💚🚀
