--
-- Table structure for table `accounts`
--

DROP TABLE IF EXISTS `accounts`;
CREATE TABLE IF NOT EXISTS `accounts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_id` int(11) NOT NULL,
  `card_id` int(11) NOT NULL,
  `amount` double(8,2) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_accounts_cards` (`card_id`),
  KEY `fk_accounts_customers` (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `accounts`
--

INSERT INTO `accounts` (`id`, `customer_id`, `card_id`, `amount`) VALUES
(1, 1, 1, 1673.00);

-- --------------------------------------------------------

--
-- Table structure for table `cards`
--

DROP TABLE IF EXISTS `cards`;
CREATE TABLE IF NOT EXISTS `cards` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` enum('0','1','2') NOT NULL,
  `num` int(11) NOT NULL,
  `exp_month` int(11) NOT NULL,
  `exp_year` int(11) NOT NULL,
  `verification_code` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `cards`
--

INSERT INTO `cards` (`id`, `type`, `num`, `exp_month`, `exp_year`, `verification_code`) VALUES
(1, '0', 123456, 1, 2022, 123);

-- --------------------------------------------------------

--
-- Table structure for table `customers`
--

DROP TABLE IF EXISTS `customers`;
CREATE TABLE IF NOT EXISTS `customers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `customers`
--

INSERT INTO `customers` (`id`, `first_name`, `last_name`, `email`) VALUES
(1, 'Mohamed', 'BOUKHLIF', 'boukhlif@gmail.com');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `accounts`
--
ALTER TABLE `accounts`
  ADD CONSTRAINT `fk_accounts_cards` FOREIGN KEY (`card_id`) REFERENCES `cards` (`id`),
  ADD CONSTRAINT `fk_accounts_customers` FOREIGN KEY (`customer_id`) REFERENCES `customers` (`id`);