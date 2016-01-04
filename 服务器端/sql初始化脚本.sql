CREATE TABLE `agency` (
  `agencyId` varchar(20) NOT NULL,
  `agencyname` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`agencyId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1

CREATE TABLE `agency_init` (
  `agencyId` varchar(20) NOT NULL,
  `agencyname` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`agencyId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1

CREATE TABLE `bankaccount` (
  `number` varchar(25) NOT NULL,
  `name` varchar(15) CHARACTER SET utf8 DEFAULT NULL,
  `money` double DEFAULT NULL,
  PRIMARY KEY (`number`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1

CREATE TABLE `bankaccount_init` (
  `number` varchar(25) NOT NULL,
  `name` varchar(15) CHARACTER SET utf8 DEFAULT NULL,
  `money` double DEFAULT NULL,
  PRIMARY KEY (`number`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1

CREATE TABLE `deliveringlist` (
  `id` varchar(25) NOT NULL,
  `timee` datetime DEFAULT NULL,
  `deliveryman` varchar(15) CHARACTER SET utf8 DEFAULT NULL,
  `checkstate` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1

CREATE TABLE `deliveringlist_barcode` (
  `primarykey` int(11) NOT NULL AUTO_INCREMENT,
  `barcode` varchar(25) NOT NULL,
  `id` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`primarykey`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1

CREATE TABLE `driver` (
  `driverNum` varchar(20) NOT NULL,
  `name` varchar(15) CHARACTER SET utf8 DEFAULT NULL,
  `idNum` varchar(20) DEFAULT NULL,
  `phoneNum` varchar(15) CHARACTER SET utf8 DEFAULT NULL,
  `sex` varchar(5) CHARACTER SET utf8 DEFAULT NULL,
  `drivingLicencePeriod` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`driverNum`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1

CREATE TABLE `hallarrivallist` (
  `id` varchar(25) NOT NULL,
  `timee` datetime DEFAULT NULL,
  `transfernumber` varchar(25) DEFAULT NULL,
  `departureplace` varchar(20) DEFAULT NULL,
  `checkstate` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

CREATE TABLE `hallarrivallist_goodinfo` (
  `primarykey` int(11) NOT NULL AUTO_INCREMENT,
  `barcode` varchar(25) NOT NULL,
  `state` varchar(15) DEFAULT NULL,
  `id` varchar(25) NOT NULL DEFAULT '',
  PRIMARY KEY (`primarykey`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT

CREATE TABLE `inittime` (
  `countt` int(11) NOT NULL AUTO_INCREMENT,
  `timee` datetime DEFAULT NULL,
  PRIMARY KEY (`countt`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT


CREATE TABLE `loadlist` (
  `transportationNumber` varchar(25) NOT NULL DEFAULT '',
  `timee` datetime DEFAULT NULL,
  `hallnumber` varchar(15) DEFAULT NULL,
  `destination` varchar(20) DEFAULT NULL,
  `carnumber` varchar(15) DEFAULT NULL,
  `guardman` varchar(15) DEFAULT NULL,
  `supercargoman` varchar(15) DEFAULT NULL,
  `checkstate` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`transportationNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8


CREATE TABLE `loadlist_barcode` (
  `primarykey` int(11) NOT NULL AUTO_INCREMENT,
  `barcode` varchar(25) NOT NULL,
  `transportationNumber` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`primarykey`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=latin1


CREATE TABLE `moneyinlist` (
  `id` varchar(20) NOT NULL,
  `timee` datetime DEFAULT NULL,
  `moneySum` double DEFAULT NULL,
  `staffId` varchar(15) CHARACTER SET utf8 DEFAULT NULL,
  `accountnum` varchar(25) NOT NULL,
  `checkstate` varchar(15) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1


CREATE TABLE `moneyinlist_barcode` (
  `primarykey` int(11) NOT NULL AUTO_INCREMENT,
  `barcode` varchar(20) NOT NULL,
  `id` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`primarykey`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1

CREATE TABLE `moneyoutlist` (
  `id` varchar(20) NOT NULL,
  `timee` datetime DEFAULT NULL,
  `money` double DEFAULT NULL,
  `payer` varchar(15) CHARACTER SET utf8 DEFAULT NULL,
  `accountNum` varchar(25) CHARACTER SET utf8 DEFAULT NULL,
  `clause` varchar(15) CHARACTER SET utf8 DEFAULT NULL,
  `note` varchar(15) CHARACTER SET utf8 DEFAULT NULL,
  `checkstate` varchar(15) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1

CREATE TABLE `orderlist` (
  `senderName` varchar(15) DEFAULT NULL,
  `senderAddress` varchar(25) DEFAULT NULL,
  `senderTeleNumber` varchar(15) DEFAULT NULL,
  `receiverName` varchar(15) DEFAULT NULL,
  `receiverAddress` varchar(25) DEFAULT NULL,
  `receiverTeleNumber` varchar(15) DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  `weight` double DEFAULT NULL,
  `volume` double DEFAULT NULL,
  `name` varchar(15) DEFAULT NULL,
  `category` varchar(10) DEFAULT NULL,
  `packPrice` double DEFAULT NULL,
  `pkgType` varchar(15) DEFAULT NULL,
  `barCode` varchar(20) NOT NULL,
  `departTime` datetime DEFAULT NULL,
  `arriveTime` datetime DEFAULT NULL,
  `checkstate` varchar(15) DEFAULT NULL,
  `realreceiver` varchar(20) DEFAULT NULL,
  `realreceivertelenumber` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`barCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT


CREATE TABLE `orderpath` (
  `primarykey` int(11) NOT NULL AUTO_INCREMENT,
  `barcode` varchar(20) NOT NULL,
  `content` varchar(50) NOT NULL,
  PRIMARY KEY (`primarykey`)
) ENGINE=InnoDB AUTO_INCREMENT=811 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT


CREATE TABLE `repertoryin` (
  `id` varchar(20) NOT NULL,
  `orderid` varchar(20) DEFAULT NULL,
  `timee` datetime DEFAULT NULL,
  `destination` varchar(20) DEFAULT NULL,
  `arenumber` varchar(5) DEFAULT NULL,
  `rownumber` varchar(5) DEFAULT NULL,
  `framenumber` varchar(5) DEFAULT NULL,
  `placenumber` varchar(5) DEFAULT NULL,
  `checkstate` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

CREATE TABLE `repertoryinfo` (
  `id` varchar(20) NOT NULL,
  `areanumber` varchar(5) NOT NULL,
  `rownumber` varchar(5) NOT NULL,
  `framenumber` varchar(5) NOT NULL,
  `placenumber` varchar(5) NOT NULL,
  `goodid` varchar(20) NOT NULL,
  PRIMARY KEY (`id`,`areanumber`,`rownumber`,`framenumber`,`placenumber`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1


CREATE TABLE `repertoryinfo_init` (
  `id` varchar(20) NOT NULL,
  `areanumber` varchar(5) NOT NULL,
  `rownumber` varchar(5) NOT NULL,
  `framenumber` varchar(5) NOT NULL,
  `placenumber` varchar(5) NOT NULL,
  `goodid` varchar(20) NOT NULL,
  PRIMARY KEY (`id`,`areanumber`,`rownumber`,`framenumber`,`placenumber`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1


CREATE TABLE `repertoryout` (
  `id` varchar(20) NOT NULL,
  `orderid` varchar(20) DEFAULT NULL,
  `timee` datetime DEFAULT NULL,
  `destination` varchar(20) DEFAULT NULL,
  `transportation` varchar(20) DEFAULT NULL,
  `transcode` varchar(20) DEFAULT NULL,
  `checkstate` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

CREATE TABLE `staff` (
  `id` varchar(20) NOT NULL,
  `name` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `sex` varchar(5) CHARACTER SET utf8 DEFAULT NULL,
  `position` varchar(25) CHARACTER SET utf8 DEFAULT NULL,
  `idNumber` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `workingstarttime` date DEFAULT NULL,
  `phoneNum` varchar(15) CHARACTER SET utf8 DEFAULT NULL,
  `wage` varchar(15) DEFAULT NULL,
  `agencyName` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `agencyId` varchar(15) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1

CREATE TABLE `staff_init` (
  `id` varchar(20) NOT NULL,
  `name` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `sex` varchar(5) CHARACTER SET utf8 DEFAULT NULL,
  `position` varchar(25) CHARACTER SET utf8 DEFAULT NULL,
  `idNumber` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `workingstarttime` date DEFAULT NULL,
  `phoneNum` varchar(15) CHARACTER SET utf8 DEFAULT NULL,
  `wage` varchar(15) DEFAULT NULL,
  `agencyName` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `agencyId` varchar(15) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1


CREATE TABLE `systemlog` (
  `primary` int(11) NOT NULL AUTO_INCREMENT,
  `logtime` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `admin` varchar(20) DEFAULT NULL,
  `content` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`primary`)
) ENGINE=InnoDB AUTO_INCREMENT=164 DEFAULT CHARSET=utf8


CREATE TABLE `transarrivallist` (
  `id` varchar(25) NOT NULL,
  `transfernumber` varchar(25) DEFAULT NULL,
  `centernumber` varchar(20) DEFAULT NULL,
  `timee` datetime DEFAULT NULL,
  `departureplace` varchar(20) DEFAULT NULL,
  `checkstate` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

CREATE TABLE `transarrivallist_goodinfo` (
  `primarykey` int(11) NOT NULL AUTO_INCREMENT,
  `barcode` varchar(25) NOT NULL,
  `state` varchar(15) DEFAULT NULL,
  `id` varchar(25) NOT NULL DEFAULT '',
  PRIMARY KEY (`primarykey`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT


CREATE TABLE `transshipmentlist` (
  `id` varchar(25) CHARACTER SET latin1 NOT NULL,
  `timee` datetime DEFAULT NULL,
  `flightnumber` varchar(15) DEFAULT NULL,
  `departureplace` varchar(15) DEFAULT NULL,
  `destination` varchar(15) DEFAULT NULL,
  `containerNumber` varchar(15) DEFAULT NULL,
  `supercargo` varchar(15) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `checkstate` varchar(15) CHARACTER SET latin1 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT


CREATE TABLE `transshipmentlist_barcode` (
  `primarykey` int(11) NOT NULL AUTO_INCREMENT,
  `barcode` varchar(25) NOT NULL,
  `id` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`primarykey`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT


CREATE TABLE `truck` (
  `vehiclecode` varchar(20) NOT NULL,
  `platenumber` varchar(15) DEFAULT NULL,
  `serviceTimeLimit` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`vehiclecode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT

CREATE TABLE `truck_init` (
  `vehiclecode` varchar(20) NOT NULL,
  `platenumber` varchar(15) DEFAULT NULL,
  `serviceTimeLimit` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`vehiclecode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT


CREATE TABLE `user` (
  `id` varchar(20) NOT NULL,
  `admin` varchar(20) NOT NULL,
  `pass` varchar(15) DEFAULT NULL,
  `Idtype` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`admin`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1


insert into user values ('000000301','admin','admin','ADMIN')
insert into staff values ('000000301','user','男','ADMIN','000','2000-1-1','000','000','快递中心','000000')
insert into user values ('000000001','topmanager','topmanger','TOP_MANAGER')
insert into staff values ('000000001','topmanager','男','TOP_MANAGER','000','2000-1-1','000','000','快递中心','000000')


