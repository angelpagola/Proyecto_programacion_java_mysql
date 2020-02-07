-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.1.59-community


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema proyecto
--

CREATE DATABASE IF NOT EXISTS proyecto;
USE proyecto;

--
-- Temporary table structure for view `vw_compramaterial`
--
DROP TABLE IF EXISTS `vw_compramaterial`;
DROP VIEW IF EXISTS `vw_compramaterial`;
CREATE TABLE `vw_compramaterial` (
  `id` int(11),
  `fecha` date,
  `cantaidad` int(11),
  `material` varchar(45),
  `marca` varchar(45),
  `color` varchar(25),
  `facultad` varchar(75),
  `stock` int(11)
);

--
-- Temporary table structure for view `vw_materiales`
--
DROP TABLE IF EXISTS `vw_materiales`;
DROP VIEW IF EXISTS `vw_materiales`;
CREATE TABLE `vw_materiales` (
  `id` int(11),
  `material` varchar(45),
  `marca` varchar(45),
  `color` varchar(25),
  `facultad` varchar(75),
  `stock` int(11)
);

--
-- Temporary table structure for view `vw_trabajadores`
--
DROP TABLE IF EXISTS `vw_trabajadores`;
DROP VIEW IF EXISTS `vw_trabajadores`;
CREATE TABLE `vw_trabajadores` (
  `DNI` varchar(8),
  `nombres` varchar(45),
  `apellidos` varchar(91),
  `cargo` varchar(45),
  `facutlad` varchar(75),
  `login` varchar(75),
  `psw` varchar(75)
);

--
-- Definition of table `cargos`
--

DROP TABLE IF EXISTS `cargos`;
CREATE TABLE `cargos` (
  `idcargo` int(11) NOT NULL AUTO_INCREMENT,
  `cargo` varchar(45) NOT NULL,
  PRIMARY KEY (`idcargo`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `cargos`
--

/*!40000 ALTER TABLE `cargos` DISABLE KEYS */;
INSERT INTO `cargos` (`idcargo`,`cargo`) VALUES 
 (1,'SECRETARIA'),
 (2,'ASISTENTE');
/*!40000 ALTER TABLE `cargos` ENABLE KEYS */;


--
-- Definition of table `colormaterial`
--

DROP TABLE IF EXISTS `colormaterial`;
CREATE TABLE `colormaterial` (
  `idColMat` int(11) NOT NULL AUTO_INCREMENT,
  `color` varchar(25) NOT NULL,
  PRIMARY KEY (`idColMat`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `colormaterial`
--

/*!40000 ALTER TABLE `colormaterial` DISABLE KEYS */;
INSERT INTO `colormaterial` (`idColMat`,`color`) VALUES 
 (1,'ROJO'),
 (2,'AMARRILLO'),
 (3,'AZUL'),
 (4,'VERDE');
/*!40000 ALTER TABLE `colormaterial` ENABLE KEYS */;


--
-- Definition of table `docentes`
--

DROP TABLE IF EXISTS `docentes`;
CREATE TABLE `docentes` (
  `iddocente` int(11) NOT NULL AUTO_INCREMENT,
  `DNI` varchar(8) NOT NULL,
  `idescuela` int(11) NOT NULL,
  PRIMARY KEY (`iddocente`),
  KEY `personas2_idx` (`DNI`),
  KEY `escuelas1_idx` (`idescuela`),
  CONSTRAINT `personas2` FOREIGN KEY (`DNI`) REFERENCES `personas` (`DNI`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `escuelas1` FOREIGN KEY (`idescuela`) REFERENCES `escuelas` (`idescuela`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `docentes`
--

/*!40000 ALTER TABLE `docentes` DISABLE KEYS */;
/*!40000 ALTER TABLE `docentes` ENABLE KEYS */;


--
-- Definition of table `entregas`
--

DROP TABLE IF EXISTS `entregas`;
CREATE TABLE `entregas` (
  `identrega` int(11) NOT NULL AUTO_INCREMENT,
  `fecentrega` datetime NOT NULL,
  `iddocente` int(11) NOT NULL,
  `idsemestre` int(11) NOT NULL,
  `idusuario` int(11) NOT NULL,
  PRIMARY KEY (`identrega`),
  KEY `docente1_idx` (`iddocente`),
  KEY `semestre1_idx` (`idsemestre`),
  KEY `usuario1_idx` (`idusuario`),
  CONSTRAINT `docente1` FOREIGN KEY (`iddocente`) REFERENCES `docentes` (`iddocente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `semestre1` FOREIGN KEY (`idsemestre`) REFERENCES `semestres` (`idsemestre`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `usuario1` FOREIGN KEY (`idusuario`) REFERENCES `usuarios` (`idusuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `entregas`
--

/*!40000 ALTER TABLE `entregas` DISABLE KEYS */;
/*!40000 ALTER TABLE `entregas` ENABLE KEYS */;


--
-- Definition of table `escuelas`
--

DROP TABLE IF EXISTS `escuelas`;
CREATE TABLE `escuelas` (
  `idescuela` int(11) NOT NULL AUTO_INCREMENT,
  `nomesc` varchar(75) NOT NULL,
  `idfacultad` int(11) NOT NULL,
  PRIMARY KEY (`idescuela`),
  KEY `facultades1_idx` (`idfacultad`),
  CONSTRAINT `facultades1` FOREIGN KEY (`idfacultad`) REFERENCES `facultades` (`idfacultad`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `escuelas`
--

/*!40000 ALTER TABLE `escuelas` DISABLE KEYS */;
INSERT INTO `escuelas` (`idescuela`,`nomesc`,`idfacultad`) VALUES 
 (1,'INGENIERIA DE SISTEMAS E INFORMATICA',1),
 (2,'MATEMATICA',1),
 (3,'ARQUITECTURA',2),
 (4,'INGENIERIA DE MINAS',3);
/*!40000 ALTER TABLE `escuelas` ENABLE KEYS */;


--
-- Definition of table `facultades`
--

DROP TABLE IF EXISTS `facultades`;
CREATE TABLE `facultades` (
  `idfacultad` int(11) NOT NULL AUTO_INCREMENT,
  `nomfac` varchar(75) NOT NULL,
  PRIMARY KEY (`idfacultad`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `facultades`
--

/*!40000 ALTER TABLE `facultades` DISABLE KEYS */;
INSERT INTO `facultades` (`idfacultad`,`nomfac`) VALUES 
 (1,'CIENCIAS'),
 (2,'INGENIERIA CIVIL'),
 (3,'INGENIERIA DE MINAS Y METALURGIA'),
 (4,'INGENIERIA IDUSTRIAS ALIMENTARIAS');
/*!40000 ALTER TABLE `facultades` ENABLE KEYS */;


--
-- Definition of table `marcas`
--

DROP TABLE IF EXISTS `marcas`;
CREATE TABLE `marcas` (
  `idmarca` int(11) NOT NULL AUTO_INCREMENT,
  `nommarca` varchar(45) NOT NULL,
  PRIMARY KEY (`idmarca`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `marcas`
--

/*!40000 ALTER TABLE `marcas` DISABLE KEYS */;
INSERT INTO `marcas` (`idmarca`,`nommarca`) VALUES 
 (1,'LAYCONZA'),
 (2,'FABER CASTELL'),
 (3,'LORO'),
 (4,'STANFORD');
/*!40000 ALTER TABLE `marcas` ENABLE KEYS */;


--
-- Definition of table `matcompra`
--

DROP TABLE IF EXISTS `matcompra`;
CREATE TABLE `matcompra` (
  `idmatCompra` int(11) NOT NULL AUTO_INCREMENT,
  `feccompra` date NOT NULL,
  `cantcompra` int(11) NOT NULL,
  `idmaterial` int(11) NOT NULL,
  `idusuario` int(11) NOT NULL,
  PRIMARY KEY (`idmatCompra`),
  KEY `materiales2_idx` (`idmaterial`),
  KEY `usuario2_idx` (`idusuario`),
  CONSTRAINT `materiales2` FOREIGN KEY (`idmaterial`) REFERENCES `materiales` (`idmaterial`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `usuario2` FOREIGN KEY (`idusuario`) REFERENCES `usuarios` (`idusuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `matcompra`
--

/*!40000 ALTER TABLE `matcompra` DISABLE KEYS */;
INSERT INTO `matcompra` (`idmatCompra`,`feccompra`,`cantcompra`,`idmaterial`,`idusuario`) VALUES 
 (1,'2020-02-07',5,1,1),
 (2,'2020-02-07',1,2,1),
 (3,'2020-02-07',1,3,1);
/*!40000 ALTER TABLE `matcompra` ENABLE KEYS */;


--
-- Definition of table `materialentrega`
--

DROP TABLE IF EXISTS `materialentrega`;
CREATE TABLE `materialentrega` (
  `idMatEntrega` int(11) NOT NULL AUTO_INCREMENT,
  `cantentrega` int(11) NOT NULL,
  `identrega` int(11) NOT NULL,
  `idmaterial` int(11) NOT NULL,
  PRIMARY KEY (`idMatEntrega`),
  KEY `materiales1_idx` (`idmaterial`),
  KEY `entregas1_idx` (`identrega`),
  CONSTRAINT `materiales1` FOREIGN KEY (`idmaterial`) REFERENCES `materiales` (`idmaterial`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `entregas1` FOREIGN KEY (`identrega`) REFERENCES `entregas` (`identrega`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `materialentrega`
--

/*!40000 ALTER TABLE `materialentrega` DISABLE KEYS */;
/*!40000 ALTER TABLE `materialentrega` ENABLE KEYS */;


--
-- Definition of table `materiales`
--

DROP TABLE IF EXISTS `materiales`;
CREATE TABLE `materiales` (
  `idmaterial` int(11) NOT NULL AUTO_INCREMENT,
  `idmarca` int(11) NOT NULL,
  `idColMat` int(11) DEFAULT NULL,
  `idTipMat` int(11) NOT NULL,
  `idfacultad` int(11) NOT NULL,
  `stock` int(11) NOT NULL,
  PRIMARY KEY (`idmaterial`),
  KEY `marcas1_idx` (`idmarca`),
  KEY `colormaterial1_idx` (`idColMat`),
  KEY `tipomaterial1_idx` (`idTipMat`),
  KEY `facultades3_idx` (`idfacultad`),
  CONSTRAINT `colormaterial1` FOREIGN KEY (`idColMat`) REFERENCES `colormaterial` (`idColMat`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `facultades3` FOREIGN KEY (`idfacultad`) REFERENCES `facultades` (`idfacultad`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `marcas1` FOREIGN KEY (`idmarca`) REFERENCES `marcas` (`idmarca`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `tipomaterial1` FOREIGN KEY (`idTipMat`) REFERENCES `tipomaterial` (`idTipMat`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `materiales`
--

/*!40000 ALTER TABLE `materiales` DISABLE KEYS */;
INSERT INTO `materiales` (`idmaterial`,`idmarca`,`idColMat`,`idTipMat`,`idfacultad`,`stock`) VALUES 
 (1,1,1,1,1,5),
 (2,1,1,1,1,6),
 (3,2,3,2,1,1);
/*!40000 ALTER TABLE `materiales` ENABLE KEYS */;


--
-- Definition of table `personas`
--

DROP TABLE IF EXISTS `personas`;
CREATE TABLE `personas` (
  `DNI` varchar(8) NOT NULL,
  `nom` varchar(45) NOT NULL,
  `apPat` varchar(45) NOT NULL,
  `apMat` varchar(45) NOT NULL,
  PRIMARY KEY (`DNI`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `personas`
--

/*!40000 ALTER TABLE `personas` DISABLE KEYS */;
INSERT INTO `personas` (`DNI`,`nom`,`apPat`,`apMat`) VALUES 
 ('00000001','MIGUEL','SILVA','ZAPATA'),
 ('00000002','WILLY','TREJO','FLORES'),
 ('00000003','DAYANITA','CHAVEZ','CABANA'),
 ('00000004','LEONIDAS','AYALA','FLORES');
/*!40000 ALTER TABLE `personas` ENABLE KEYS */;


--
-- Definition of table `semestres`
--

DROP TABLE IF EXISTS `semestres`;
CREATE TABLE `semestres` (
  `idsemestre` int(11) NOT NULL AUTO_INCREMENT,
  `nomSem` varchar(20) NOT NULL,
  `fecinicio` date NOT NULL,
  `fecsalida` date NOT NULL,
  PRIMARY KEY (`idsemestre`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `semestres`
--

/*!40000 ALTER TABLE `semestres` DISABLE KEYS */;
INSERT INTO `semestres` (`idsemestre`,`nomSem`,`fecinicio`,`fecsalida`) VALUES 
 (1,'2019-II','2019-09-05','2020-02-25');
/*!40000 ALTER TABLE `semestres` ENABLE KEYS */;


--
-- Definition of table `tipomaterial`
--

DROP TABLE IF EXISTS `tipomaterial`;
CREATE TABLE `tipomaterial` (
  `idTipMat` int(11) NOT NULL AUTO_INCREMENT,
  `nomTip` varchar(45) NOT NULL,
  PRIMARY KEY (`idTipMat`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tipomaterial`
--

/*!40000 ALTER TABLE `tipomaterial` DISABLE KEYS */;
INSERT INTO `tipomaterial` (`idTipMat`,`nomTip`) VALUES 
 (1,'PLUMON'),
 (2,'MOTA');
/*!40000 ALTER TABLE `tipomaterial` ENABLE KEYS */;


--
-- Definition of table `trabajadores`
--

DROP TABLE IF EXISTS `trabajadores`;
CREATE TABLE `trabajadores` (
  `idtrabajador` int(11) NOT NULL AUTO_INCREMENT,
  `idcargo` int(11) NOT NULL,
  `DNI` varchar(8) NOT NULL,
  `idfacultad` int(11) NOT NULL,
  PRIMARY KEY (`idtrabajador`),
  KEY `cargos_idx` (`idcargo`),
  KEY `personas1_idx` (`DNI`),
  KEY `facultades2_idx` (`idfacultad`),
  CONSTRAINT `cargos` FOREIGN KEY (`idcargo`) REFERENCES `cargos` (`idcargo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `personas1` FOREIGN KEY (`DNI`) REFERENCES `personas` (`DNI`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `facultades2` FOREIGN KEY (`idfacultad`) REFERENCES `facultades` (`idfacultad`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `trabajadores`
--

/*!40000 ALTER TABLE `trabajadores` DISABLE KEYS */;
INSERT INTO `trabajadores` (`idtrabajador`,`idcargo`,`DNI`,`idfacultad`) VALUES 
 (1,1,'00000003',1),
 (2,2,'00000004',1);
/*!40000 ALTER TABLE `trabajadores` ENABLE KEYS */;


--
-- Definition of table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE `usuarios` (
  `idusuario` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(75) NOT NULL,
  `psw` varchar(75) NOT NULL,
  `idtrabajador` int(11) NOT NULL,
  PRIMARY KEY (`idusuario`),
  KEY `trabajadores1_idx` (`idtrabajador`),
  CONSTRAINT `trabajadores1` FOREIGN KEY (`idtrabajador`) REFERENCES `trabajadores` (`idtrabajador`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `usuarios`
--

/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` (`idusuario`,`login`,`psw`,`idtrabajador`) VALUES 
 (1,'root','63a9f0ea7bb98050796b649e85481845',1),
 (2,'00000004','a527173445d117cbf177084bd34e60f2',2);
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;


--
-- Definition of procedure `proc_materialcompra`
--

DROP PROCEDURE IF EXISTS `proc_materialcompra`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_materialcompra`(id int,tipmat varchar(50),marca varchar(50), col varchar(45),nmfac varchar(75),
cant int, us varchar(45))
BEGIN
  set @idtipomat=(select idTipMat from tipomaterial where nomTip=tipmat);
  set @idmarc=(select idmarca from marcas where nommarca=marca);
  set @idcol=(select idColMat from colormaterial where color=col);
  set @idfac=(select idfacultad from facultades where nomfac=nmfac);
  set @stoc=(select stock from materiales where idTipMat=@idtipomat order by idmaterial desc limit 1);
  if(select count(*) from materiales where  idTipMat=@idtipomat )!=0 then
    insert into materiales(idmarca,idColMat,idTipMat,idfacultad,stock) values (@idmarc,@idcol,@idtipomat,@idfac,(@stoc+cant));
  else
  insert into materiales(idmarca,idColMat,idTipMat,idfacultad,stock) values (@idmarc,@idcol,@idtipomat,@idfac,cant);
  end if;
  set @idmater=(select idmaterial from materiales order by idmaterial desc limit 1);
  set @idus=(select idusuario from usuarios where login=us);
  insert into matCompra(feccompra,cantcompra,idmaterial,idusuario) values(curdate(),cant,@idmater,@idus);

  select concat('Se realizó la compra correctamente');
END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `proc_trabajadores`
--

DROP PROCEDURE IF EXISTS `proc_trabajadores`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_trabajadores`(doc varchar(8),nomb varchar(45),apat varchar(45),amat varchar(45),nmcargo varchar(45),
nomfc varchar(75),lg varchar(45),pas varchar(75))
BEGIN
  if(select count(*) from personas where dni=doc)=0 then
    if(select count(*) from usuarios where login=lg)=0 then
      insert into personas(DNI,nom,apPat,apMat) values(doc,nomb,apat,amat);
      set @dniper=(select dni from personas where dni=doc);
      set @idcar=(select idcargo from cargos where cargo=nmcargo);
      set @idfac=(select idfacultad from facultades where nomfac=nomfc);
      insert into trabajadores(idcargo,DNI,idfacultad) values(@idcar,@dniper,@idfac);
      set @idtrab=(select idtrabajador from trabajadores order by idtrabajador desc limit 1);
      insert into usuarios(login,psw,idtrabajador) values (lg,pas,@idtrab);
      select concat('Se registró el trabaja;dor correctamente');
    else
      select concat('El usuario ya existe');
    end if;
  else
    if(select count(*) from usuarios where login=lg)=0 then
      set @dniper=(select dni from personas where dni=doc);
      set @idcar=(select idcargo from cargos where cargo=nmcargo);
      set @idfac=(select idfacultad from facultades where nomfac=nomfc);
      insert into trabajadores(idcargo,DNI,idfacultad) values(@idcar,@dniper,@idfac);
      set @idtrab=(select idtrabajador from trabajadores order by idtrabajador desc limit 1);
      insert into usuarios(login,psw,idtrabajador) values (lg,pas,@idtrab);
      select concat('Se registró el trabaja;dor correctamente');
    else
      select concat('El usuario ya existe');
    end if;
  end if;
END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of view `vw_compramaterial`
--

DROP TABLE IF EXISTS `vw_compramaterial`;
DROP VIEW IF EXISTS `vw_compramaterial`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vw_compramaterial` AS select `mc`.`idmatCompra` AS `id`,`mc`.`feccompra` AS `fecha`,`mc`.`cantcompra` AS `cantaidad`,`tm`.`nomTip` AS `material`,`mr`.`nommarca` AS `marca`,`c`.`color` AS `color`,`f`.`nomfac` AS `facultad`,`m`.`stock` AS `stock` from (((((`materiales` `m` join `tipomaterial` `tm`) join `marcas` `mr`) join `facultades` `f`) join `colormaterial` `c`) join `matcompra` `mc`) where ((`tm`.`idTipMat` = `m`.`idTipMat`) and (`mr`.`idmarca` = `m`.`idmarca`) and (`f`.`idfacultad` = `m`.`idfacultad`) and (`c`.`idColMat` = `m`.`idColMat`) and (`m`.`idmaterial` = `mc`.`idmaterial`));

--
-- Definition of view `vw_materiales`
--

DROP TABLE IF EXISTS `vw_materiales`;
DROP VIEW IF EXISTS `vw_materiales`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vw_materiales` AS select `m`.`idmaterial` AS `id`,`tm`.`nomTip` AS `material`,`mr`.`nommarca` AS `marca`,`c`.`color` AS `color`,`f`.`nomfac` AS `facultad`,`m`.`stock` AS `stock` from ((((`materiales` `m` join `tipomaterial` `tm`) join `marcas` `mr`) join `facultades` `f`) join `colormaterial` `c`) where ((`tm`.`idTipMat` = `m`.`idTipMat`) and (`mr`.`idmarca` = `m`.`idmarca`) and (`f`.`idfacultad` = `m`.`idfacultad`) and (`c`.`idColMat` = `m`.`idColMat`));

--
-- Definition of view `vw_trabajadores`
--

DROP TABLE IF EXISTS `vw_trabajadores`;
DROP VIEW IF EXISTS `vw_trabajadores`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vw_trabajadores` AS select `p`.`DNI` AS `DNI`,`p`.`nom` AS `nombres`,concat(`p`.`apPat`,' ',`p`.`apMat`) AS `apellidos`,`c`.`cargo` AS `cargo`,`f`.`nomfac` AS `facutlad`,`u`.`login` AS `login`,`u`.`psw` AS `psw` from ((((`personas` `p` join `cargos` `c`) join `facultades` `f`) join `trabajadores` `t`) join `usuarios` `u`) where ((`p`.`DNI` = `t`.`DNI`) and (`c`.`idcargo` = `t`.`idcargo`) and (`f`.`idfacultad` = `t`.`idfacultad`) and (`t`.`idtrabajador` = `u`.`idtrabajador`));



/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
