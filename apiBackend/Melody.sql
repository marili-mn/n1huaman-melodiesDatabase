SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

----------------------------------------------------------

DROP TABLE IF EXISTS `melodies`;
CREATE TABLE IF NOT EXISTS `melodies` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `genre` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `duration` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `images` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `melodies`
--

INSERT INTO melodies (title, genre, duration, images) VALUES
('Sandstorm', 'Trance', '3:45', 'https://i.ytimg.com/vi/Mu9-E6gTNw0/maxresdefault.jpg'),
('Blue (Da Ba Dee)', 'Eurodance', '3:39', 'https://i.discogs.com/i21sehJ8w46_uG-wV-mx1fIdSOOQrFuEtunroh8R3S8/rs:fit/g:sm/q:90/h:604/w:600/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTcwMTQ5/MjctMTQzMTcxMzA0/MS02NzQ3LmpwZWc.jpeg'),
('Insomnia', 'Trance', '3:05', 'https://f4.bcbits.com/img/a3075269963_10.jpg'),
('Better Off Alone', 'Eurodance', '3:36', 'https://www.eurodance-90-cd-shop.com/wp-content/uploads/2018/04/img644-600x524.jpg'),
('Adagio for Strings', 'Trance', '6:35', 'https://i.ytimg.com/vi/is9A5bcOTPk/hqdefault.jpg'),
('Kernkraft 400', 'Electro', '3:30', 'https://m.media-amazon.com/images/I/51vbygyVynL._AC_SX450_.jpg')