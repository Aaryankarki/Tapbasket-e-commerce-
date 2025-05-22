-- Database: `Tap-basket television e-commerce`

-- --------------------------------------------------------
-- Table: `orders`
-- --------------------------------------------------------

CREATE TABLE `orders` (
  `orderid` varchar(45) NOT NULL,
  `prodid` varchar(45) NOT NULL,
  `quantity` int(11) DEFAULT NULL,
  `amount` decimal(10,2) DEFAULT NULL,
  `shipped` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`orderid`, `prodid`),
  KEY `prodid` (`prodid`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`prodid`) REFERENCES `product` (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


-- --------------------------------------------------------
-- Table: `product`
-- --------------------------------------------------------

CREATE TABLE `product` (
  `pid` varchar(45) NOT NULL,
  `pname` varchar(100) DEFAULT NULL,
  `ptype` varchar(20) DEFAULT NULL,
  `pinfo` varchar(350) DEFAULT NULL,
  `pprice` decimal(12,2) DEFAULT NULL,
  `pquantity` int(11) DEFAULT NULL,
  `image` longblob DEFAULT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------
-- Table: `transactions`
-- --------------------------------------------------------

CREATE TABLE `transactions` (
  `transid` varchar(45) NOT NULL,
  `username` varchar(60) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `amount` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`transid`),
  KEY `username` (`username`),
  CONSTRAINT `transactions_ibfk_1` FOREIGN KEY (`username`) REFERENCES `user` (`email`),
  CONSTRAINT `transactions_ibfk_2` FOREIGN KEY (`transid`) REFERENCES `orders` (`orderid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------
-- Table: `user`
-- --------------------------------------------------------

CREATE TABLE `user` (
  `email` varchar(60) NOT NULL,
  `name` varchar(30) DEFAULT NULL,
  `mobile` bigint(20) DEFAULT NULL,
  `address` varchar(250) DEFAULT NULL,
  `pincode` int(11) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` enum('admin', 'customer') NOT NULL DEFAULT 'customer',
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------
-- Table: `usercart`
-- --------------------------------------------------------

CREATE TABLE `usercart` (
  `username` varchar(60) DEFAULT NULL,
  `prodid` varchar(45) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  KEY `username` (`username`),
  KEY `prodid` (`prodid`),
  CONSTRAINT `usercart_ibfk_1` FOREIGN KEY (`username`) REFERENCES `user` (`email`),
  CONSTRAINT `usercart_ibfk_2` FOREIGN KEY (`prodid`) REFERENCES `product` (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------
-- Table: `user_demand`
-- --------------------------------------------------------

CREATE TABLE `user_demand` (
  `username` varchar(60) NOT NULL,
  `prodid` varchar(45) NOT NULL,
  `quantity` int(11) DEFAULT NULL,
  PRIMARY KEY (`username`, `prodid`),
  KEY `prodid` (`prodid`),
  CONSTRAINT `user_demand_ibfk_1` FOREIGN KEY (`username`) REFERENCES `user` (`email`),
  CONSTRAINT `user_demand_ibfk_2` FOREIGN KEY (`prodid`) REFERENCES `product` (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;