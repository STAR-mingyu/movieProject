package data.movie.chart;

import java.sql.Connection;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data.user.member.Gender;
import data.user.member.MemberDto;
import db.mysql.DbConnect;

public class MovieInfoDao {

	DbConnect db = new DbConnect();

	// 예매순 1위 ~ 3위
	public List<MovieInfoDto> getThreeMovieData() {
		List<MovieInfoDto> list = new ArrayList<MovieInfoDto>();

		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT MI.MOVIE_ID, MI.MOVIE_TITLE, MI.RUNNING_TIME, MI.VIEWING_RATING, MI.DIRECTOR, MI.CAST, MI.BOOKING_RATE, "
				+ "MI.RELEASE_DATE, MI.GENRE, MI.MOVIE_DESCRIPTION, MI.RATING, MI.END_DATE, MI.COUNTRY, "
				+ "M_IMAGES.IMAGE_LINK " + "FROM MOVIE_INFO MI "
				+ "LEFT JOIN MOVIE_IMAGES M_IMAGES ON MI.MOVIE_ID = M_IMAGES.MOVIE_ID "
				+ "WHERE M_IMAGES.IMAGE_ID = MI.MOVIE_ID " + "ORDER BY MI.BOOKING_RATE DESC " + "LIMIT 3";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				MovieInfoDto dto = new MovieInfoDto();

				dto.setMovieId(rs.getString("movie_id"));
				dto.setMovieTitle(rs.getString("movie_title"));
				dto.setRunningTime(rs.getInt("running_time"));
				dto.setViewingRating(rs.getString("viewing_rating"));
				dto.setDirector(rs.getString("director"));
				dto.setCast(rs.getString("cast"));
				dto.setBookingRate(rs.getDouble("booking_rate"));
				dto.setReleaseDate(rs.getDate("release_date"));
				dto.setGenre(rs.getString("genre"));
				dto.setMovieDescription(rs.getString("movie_description"));
				dto.setRating(rs.getDouble("rating"));
				dto.setEndDate(rs.getDate("end_date"));
				dto.setCountry(rs.getString("country"));
				dto.setImageLink(rs.getString("image_link"));

				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}
		return list;
	}

	// 예매순 4위 ~ 19위
	public List<MovieInfoDto> getElseMovieData() {
		List<MovieInfoDto> elist = new ArrayList<MovieInfoDto>();

		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT MI.MOVIE_ID, MI.MOVIE_TITLE, MI.RUNNING_TIME, MI.VIEWING_RATING, MI.DIRECTOR, MI.CAST, MI.BOOKING_RATE, "
				+ "MI.RELEASE_DATE, MI.GENRE, MI.MOVIE_DESCRIPTION, MI.RATING, MI.END_DATE, MI.COUNTRY, "
				+ "M_IMAGES.IMAGE_LINK " + "FROM MOVIE_INFO MI "
				+ "LEFT JOIN MOVIE_IMAGES M_IMAGES ON MI.MOVIE_ID = M_IMAGES.MOVIE_ID "
				+ "WHERE M_IMAGES.IMAGE_ID = MI.MOVIE_ID " + "order by MI.booking_rate DESC LIMIT 15 OFFSET 3";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				MovieInfoDto dto = new MovieInfoDto();

				dto.setMovieId(rs.getString("movie_id"));
				dto.setMovieTitle(rs.getString("movie_title"));
				dto.setRunningTime(rs.getInt("running_time"));
				dto.setViewingRating(rs.getString("viewing_rating"));
				dto.setDirector(rs.getString("director"));
				dto.setCast(rs.getString("cast"));
				dto.setBookingRate(rs.getDouble("booking_rate"));
				dto.setReleaseDate(rs.getDate("release_date"));
				dto.setGenre(rs.getString("genre"));
				dto.setMovieDescription(rs.getString("movie_description"));
				dto.setRating(rs.getDouble("rating"));
				dto.setEndDate(rs.getDate("end_date"));
				dto.setCountry(rs.getString("country"));
				dto.setImageLink(rs.getString("image_link"));

				elist.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}
		return elist;
	}

	// 평점순 1위 ~ 3위
	public List<MovieInfoDto> getThreeMovieData2() {
		List<MovieInfoDto> listtwo = new ArrayList<MovieInfoDto>();

		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT MI.MOVIE_ID, MI.MOVIE_TITLE, MI.RUNNING_TIME, MI.VIEWING_RATING, MI.DIRECTOR, MI.CAST, MI.BOOKING_RATE, "
				+ "MI.RELEASE_DATE, MI.GENRE, MI.MOVIE_DESCRIPTION, MI.RATING, MI.END_DATE, MI.COUNTRY, "
				+ "M_IMAGES.IMAGE_LINK " + "FROM MOVIE_INFO MI "
				+ "LEFT JOIN MOVIE_IMAGES M_IMAGES ON MI.MOVIE_ID = M_IMAGES.MOVIE_ID "
				+ "WHERE M_IMAGES.IMAGE_ID = MI.MOVIE_ID " + "order by MI.rating desc limit 3";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				MovieInfoDto dto = new MovieInfoDto();

				dto.setMovieId(rs.getString("movie_id"));
				dto.setMovieTitle(rs.getString("movie_title"));
				dto.setRunningTime(rs.getInt("running_time"));
				dto.setViewingRating(rs.getString("viewing_rating"));
				dto.setDirector(rs.getString("director"));
				dto.setCast(rs.getString("cast"));
				dto.setBookingRate(rs.getDouble("booking_rate"));
				dto.setReleaseDate(rs.getDate("release_date"));
				dto.setGenre(rs.getString("genre"));
				dto.setMovieDescription(rs.getString("movie_description"));
				dto.setRating(rs.getDouble("rating"));
				dto.setEndDate(rs.getDate("end_date"));
				dto.setCountry(rs.getString("country"));
				dto.setImageLink(rs.getString("image_link"));

				listtwo.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}
		return listtwo;
	}

	// 평점순 4위 ~ 19위
	public List<MovieInfoDto> getElseMovieData2() {
		List<MovieInfoDto> elisttwo = new ArrayList<MovieInfoDto>();

		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT MI.MOVIE_ID, MI.MOVIE_TITLE, MI.RUNNING_TIME, MI.VIEWING_RATING, MI.DIRECTOR, MI.CAST, MI.BOOKING_RATE, "
				+ "MI.RELEASE_DATE, MI.GENRE, MI.MOVIE_DESCRIPTION, MI.RATING, MI.END_DATE, MI.COUNTRY, "
				+ "M_IMAGES.IMAGE_LINK " + "FROM MOVIE_INFO MI "
				+ "LEFT JOIN MOVIE_IMAGES M_IMAGES ON MI.MOVIE_ID = M_IMAGES.MOVIE_ID "
				+ "WHERE M_IMAGES.IMAGE_ID = MI.MOVIE_ID " + "order by MI.rating desc LIMIT 15 OFFSET 3";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				MovieInfoDto dto = new MovieInfoDto();

				dto.setMovieId(rs.getString("movie_id"));
				dto.setMovieTitle(rs.getString("movie_title"));
				dto.setRunningTime(rs.getInt("running_time"));
				dto.setViewingRating(rs.getString("viewing_rating"));
				dto.setDirector(rs.getString("director"));
				dto.setCast(rs.getString("cast"));
				dto.setBookingRate(rs.getDouble("booking_rate"));
				dto.setReleaseDate(rs.getDate("release_date"));
				dto.setGenre(rs.getString("genre"));
				dto.setMovieDescription(rs.getString("movie_description"));
				dto.setRating(rs.getDouble("rating"));
				dto.setEndDate(rs.getDate("end_date"));
				dto.setCountry(rs.getString("country"));
				dto.setImageLink(rs.getString("image_link"));

				elisttwo.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}
		return elisttwo;
	}

	// 현재상영작 chk 예매순 1위 ~ 3위
	public List<MovieInfoDto> getThreeMovieDataChk() {
		List<MovieInfoDto> listchk = new ArrayList<MovieInfoDto>();

		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT MI.MOVIE_ID, MI.MOVIE_TITLE, MI.RUNNING_TIME, MI.VIEWING_RATING, MI.DIRECTOR, MI.CAST, MI.BOOKING_RATE, "
				+ "MI.RELEASE_DATE, MI.GENRE, MI.MOVIE_DESCRIPTION, MI.RATING, MI.END_DATE, MI.COUNTRY, "
				+ "M_IMAGES.IMAGE_LINK " + "FROM MOVIE_INFO MI "
				+ "LEFT JOIN MOVIE_IMAGES M_IMAGES ON MI.MOVIE_ID = M_IMAGES.MOVIE_ID "
				+ "WHERE M_IMAGES.IMAGE_ID = MI.MOVIE_ID and MI.RELEASE_DATE <= curdate() "
				+ "ORDER BY MI.BOOKING_RATE DESC " + "LIMIT 3";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				MovieInfoDto dto = new MovieInfoDto();

				dto.setMovieId(rs.getString("movie_id"));
				dto.setMovieTitle(rs.getString("movie_title"));
				dto.setRunningTime(rs.getInt("running_time"));
				dto.setViewingRating(rs.getString("viewing_rating"));
				dto.setDirector(rs.getString("director"));
				dto.setCast(rs.getString("cast"));
				dto.setBookingRate(rs.getDouble("booking_rate"));
				dto.setReleaseDate(rs.getDate("release_date"));
				dto.setGenre(rs.getString("genre"));
				dto.setMovieDescription(rs.getString("movie_description"));
				dto.setRating(rs.getDouble("rating"));
				dto.setEndDate(rs.getDate("end_date"));
				dto.setCountry(rs.getString("country"));
				dto.setImageLink(rs.getString("image_link"));

				listchk.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}
		return listchk;
	}

	// 현재상영작 chk 예매순 4위 ~ 19위
	public List<MovieInfoDto> getElseMovieDataChk() {
		List<MovieInfoDto> elistchk = new ArrayList<MovieInfoDto>();

		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT MI.MOVIE_ID, MI.MOVIE_TITLE, MI.RUNNING_TIME, MI.VIEWING_RATING, MI.DIRECTOR, MI.CAST, MI.BOOKING_RATE, "
				+ "MI.RELEASE_DATE, MI.GENRE, MI.MOVIE_DESCRIPTION, MI.RATING, MI.END_DATE, MI.COUNTRY, "
				+ "M_IMAGES.IMAGE_LINK " + "FROM MOVIE_INFO MI "
				+ "LEFT JOIN MOVIE_IMAGES M_IMAGES ON MI.MOVIE_ID = M_IMAGES.MOVIE_ID "
				+ "WHERE M_IMAGES.IMAGE_ID = MI.MOVIE_ID and MI.RELEASE_DATE <= curdate() "
				+ "ORDER BY MI.BOOKING_RATE DESC " + "LIMIT 15 OFFSET 3";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				MovieInfoDto dto = new MovieInfoDto();

				dto.setMovieId(rs.getString("movie_id"));
				dto.setMovieTitle(rs.getString("movie_title"));
				dto.setRunningTime(rs.getInt("running_time"));
				dto.setViewingRating(rs.getString("viewing_rating"));
				dto.setDirector(rs.getString("director"));
				dto.setCast(rs.getString("cast"));
				dto.setBookingRate(rs.getDouble("booking_rate"));
				dto.setReleaseDate(rs.getDate("release_date"));
				dto.setGenre(rs.getString("genre"));
				dto.setMovieDescription(rs.getString("movie_description"));
				dto.setRating(rs.getDouble("rating"));
				dto.setEndDate(rs.getDate("end_date"));
				dto.setCountry(rs.getString("country"));
				dto.setImageLink(rs.getString("image_link"));

				elistchk.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}
		return elistchk;
	}

	// 현재상영작 chk 평점순 1위 ~ 3위
	public List<MovieInfoDto> getThreeMovieDataChk2() {
		List<MovieInfoDto> listtwochk = new ArrayList<MovieInfoDto>();

		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT MI.MOVIE_ID, MI.MOVIE_TITLE, MI.RUNNING_TIME, MI.VIEWING_RATING, MI.DIRECTOR, MI.CAST, MI.BOOKING_RATE, "
				+ "MI.RELEASE_DATE, MI.GENRE, MI.MOVIE_DESCRIPTION, MI.RATING, MI.END_DATE, MI.COUNTRY, "
				+ "M_IMAGES.IMAGE_LINK " + "FROM MOVIE_INFO MI "
				+ "LEFT JOIN MOVIE_IMAGES M_IMAGES ON MI.MOVIE_ID = M_IMAGES.MOVIE_ID "
				+ "WHERE M_IMAGES.IMAGE_ID = MI.MOVIE_ID and MI.RELEASE_DATE <= curdate() " + "ORDER BY MI.rating DESC "
				+ "LIMIT 3";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				MovieInfoDto dto = new MovieInfoDto();

				dto.setMovieId(rs.getString("movie_id"));
				dto.setMovieTitle(rs.getString("movie_title"));
				dto.setRunningTime(rs.getInt("running_time"));
				dto.setViewingRating(rs.getString("viewing_rating"));
				dto.setDirector(rs.getString("director"));
				dto.setCast(rs.getString("cast"));
				dto.setBookingRate(rs.getDouble("booking_rate"));
				dto.setReleaseDate(rs.getDate("release_date"));
				dto.setGenre(rs.getString("genre"));
				dto.setMovieDescription(rs.getString("movie_description"));
				dto.setRating(rs.getDouble("rating"));
				dto.setEndDate(rs.getDate("end_date"));
				dto.setCountry(rs.getString("country"));
				dto.setImageLink(rs.getString("image_link"));

				listtwochk.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}
		return listtwochk;
	}

	// 현재상영작 chk 평점순 4위 ~ 19위
	public List<MovieInfoDto> getElseMovieDataChk2() {
		List<MovieInfoDto> elisttwochk = new ArrayList<MovieInfoDto>();

		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT MI.MOVIE_ID, MI.MOVIE_TITLE, MI.RUNNING_TIME, MI.VIEWING_RATING, MI.DIRECTOR, MI.CAST, MI.BOOKING_RATE, "
				+ "MI.RELEASE_DATE, MI.GENRE, MI.MOVIE_DESCRIPTION, MI.RATING, MI.END_DATE, MI.COUNTRY, "
				+ "M_IMAGES.IMAGE_LINK " + "FROM MOVIE_INFO MI "
				+ "LEFT JOIN MOVIE_IMAGES M_IMAGES ON MI.MOVIE_ID = M_IMAGES.MOVIE_ID "
				+ "WHERE M_IMAGES.IMAGE_ID = MI.MOVIE_ID and MI.RELEASE_DATE <= curdate() " + "ORDER BY MI.rating DESC "
				+ "LIMIT 15 OFFSET 3";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				MovieInfoDto dto = new MovieInfoDto();

				dto.setMovieId(rs.getString("movie_id"));
				dto.setMovieTitle(rs.getString("movie_title"));
				dto.setRunningTime(rs.getInt("running_time"));
				dto.setViewingRating(rs.getString("viewing_rating"));
				dto.setDirector(rs.getString("director"));
				dto.setCast(rs.getString("cast"));
				dto.setBookingRate(rs.getDouble("booking_rate"));
				dto.setReleaseDate(rs.getDate("release_date"));
				dto.setGenre(rs.getString("genre"));
				dto.setMovieDescription(rs.getString("movie_description"));
				dto.setRating(rs.getDouble("rating"));
				dto.setEndDate(rs.getDate("end_date"));
				dto.setCountry(rs.getString("country"));
				dto.setImageLink(rs.getString("image_link"));

				elisttwochk.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}
		return elisttwochk;
	}

	// 상영예정작 예매순 1위 ~ 3위
	public List<MovieInfoDto> getThreeMovieSchedule() {
		List<MovieInfoDto> listschedule = new ArrayList<MovieInfoDto>();

		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT MI.MOVIE_ID, MI.MOVIE_TITLE, MI.RUNNING_TIME, MI.VIEWING_RATING, MI.DIRECTOR, MI.CAST, MI.BOOKING_RATE, "
				+ "MI.RELEASE_DATE, MI.GENRE, MI.MOVIE_DESCRIPTION, MI.RATING, MI.END_DATE, MI.COUNTRY, "
				+ "M_IMAGES.IMAGE_LINK " + "FROM MOVIE_INFO MI "
				+ "LEFT JOIN MOVIE_IMAGES M_IMAGES ON MI.MOVIE_ID = M_IMAGES.MOVIE_ID "
				+ "WHERE M_IMAGES.IMAGE_ID = MI.MOVIE_ID and MI.RELEASE_DATE > curdate() "
				+ "ORDER BY MI.booking_rate DESC " + "LIMIT 3";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				MovieInfoDto dto = new MovieInfoDto();

				dto.setMovieId(rs.getString("movie_id"));
				dto.setMovieTitle(rs.getString("movie_title"));
				dto.setRunningTime(rs.getInt("running_time"));
				dto.setViewingRating(rs.getString("viewing_rating"));
				dto.setDirector(rs.getString("director"));
				dto.setCast(rs.getString("cast"));
				dto.setBookingRate(rs.getDouble("booking_rate"));
				dto.setReleaseDate(rs.getDate("release_date"));
				dto.setGenre(rs.getString("genre"));
				dto.setMovieDescription(rs.getString("movie_description"));
				dto.setRating(rs.getDouble("rating"));
				dto.setEndDate(rs.getDate("end_date"));
				dto.setCountry(rs.getString("country"));
				dto.setImageLink(rs.getString("image_link"));

				listschedule.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}
		return listschedule;
	}

	// 상영예정작 예매순 날짜별
	public List<MovieInfoDto> getElseMovieSchedule() {
		List<MovieInfoDto> elistschedule = new ArrayList<MovieInfoDto>();

		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT MI.MOVIE_ID, MI.MOVIE_TITLE, MI.RUNNING_TIME, MI.VIEWING_RATING, MI.DIRECTOR, MI.CAST, MI.BOOKING_RATE, "
				+ "MI.RELEASE_DATE, MI.GENRE, MI.MOVIE_DESCRIPTION, MI.RATING, MI.END_DATE, MI.COUNTRY, M_IMAGES.IMAGE_LINK "
				+ "FROM MOVIE_INFO MI LEFT JOIN MOVIE_IMAGES M_IMAGES ON MI.MOVIE_ID = M_IMAGES.MOVIE_ID "
				+ "WHERE M_IMAGES.IMAGE_ID = MI.MOVIE_ID and MI.RELEASE_DATE > curdate() order by MI.release_date";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				MovieInfoDto dto = new MovieInfoDto();

				dto.setMovieId(rs.getString("movie_id"));
				dto.setMovieTitle(rs.getString("movie_title"));
				dto.setRunningTime(rs.getInt("running_time"));
				dto.setViewingRating(rs.getString("viewing_rating"));
				dto.setDirector(rs.getString("director"));
				dto.setCast(rs.getString("cast"));
				dto.setBookingRate(rs.getDouble("booking_rate"));
				dto.setReleaseDate(rs.getDate("release_date"));
				dto.setGenre(rs.getString("genre"));
				dto.setMovieDescription(rs.getString("movie_description"));
				dto.setRating(rs.getDouble("rating"));
				dto.setEndDate(rs.getDate("end_date"));
				dto.setCountry(rs.getString("country"));
				dto.setImageLink(rs.getString("image_link"));

				elistschedule.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}
		return elistschedule;
	}

	//movie_id에 대한 dto 반환
	public MovieInfoDto getData(String movie_id) {
		MovieInfoDto dto = new MovieInfoDto();

		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT MI.MOVIE_ID, MI.MOVIE_TITLE, MI.RUNNING_TIME, MI.VIEWING_RATING, MI.DIRECTOR, MI.CAST, MI.BOOKING_RATE, \r\n"
				+ "MI.RELEASE_DATE, MI.GENRE, MI.MOVIE_DESCRIPTION, MI.RATING, MI.END_DATE, MI.COUNTRY,\r\n"
				+ "M_IMAGES.IMAGE_LINK\r\n"
				+ "FROM MOVIE_INFO MI\r\n"
				+ "LEFT JOIN MOVIE_IMAGES M_IMAGES ON MI.MOVIE_ID = M_IMAGES.MOVIE_ID\r\n"
				+ "WHERE MI.MOVIE_ID = ? and M_IMAGES.IMAGE_ID = MI.Movie_id";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, movie_id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				dto.setMovieId(rs.getString("movie_id"));
				dto.setMovieTitle(rs.getString("movie_title"));
				dto.setRunningTime(rs.getInt("running_time"));
				dto.setViewingRating(rs.getString("viewing_rating"));
				dto.setDirector(rs.getString("director"));
				dto.setCast(rs.getString("cast"));
				dto.setBookingRate(rs.getDouble("booking_rate"));
				dto.setReleaseDate(rs.getDate("release_date"));
				dto.setGenre(rs.getString("genre"));
				dto.setMovieDescription(rs.getString("movie_description"));
				dto.setRating(rs.getDouble("rating"));
				dto.setEndDate(rs.getDate("end_date"));
				dto.setCountry(rs.getString("country"));
				dto.setImageLink(rs.getString("image_link"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}
		return dto;
	}

	public List<MovieInfoDto> getAllMovies() {
		List<MovieInfoDto> list = new ArrayList<>();

		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		String sql="select * from MOVIE_INFO order by member_id";

		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();

			while(rs.next())
			{
				MovieInfoDto dto = new MovieInfoDto();
				dto.setMovieId(rs.getString("movie_id"));
				dto.setMovieTitle(rs.getString("movie_title"));
				dto.setRunningTime(rs.getInt("running_time"));
				dto.setViewingRating(rs.getString("viewing_rating"));
				dto.setDirector(rs.getString("director"));
				dto.setCast(rs.getString("cast"));
				dto.setBookingRate(rs.getDouble("booking_rate"));
				dto.setReleaseDate(rs.getDate("release_date"));
				dto.setGenre(rs.getString("genre"));
				dto.setMovieDescription(rs.getString("movie_description"));
				dto.setRating(rs.getDouble("rating"));
				dto.setEndDate(rs.getDate("end_date"));
				dto.setCountry(rs.getString("country"));
				//TODO
				// 대표 이미지 추가
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
		}
		return list;
	}

	public int getMovieCount() {
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select count(*) from MOVIE_INFO";
		int count = 0;

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt(1);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
		}
		return count;
	}

	//페이지
	public List<MovieInfoDto> getList(int start,int perPage)
	{
		List<MovieInfoDto> list=new ArrayList<>();
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		String sql="select * from MOVIE_INFO order by movie_id desc limit ?,?";

		try {
			pstmt=conn.prepareStatement(sql);

			pstmt.setInt(1, start);
			pstmt.setInt(2, perPage);

			rs=pstmt.executeQuery();

			while(rs.next())
			{
				MovieInfoDto dto = new MovieInfoDto();
				dto.setMovieId(rs.getString("movie_id"));
				dto.setMovieTitle(rs.getString("movie_title"));
				dto.setRunningTime(rs.getInt("running_time"));
				dto.setViewingRating(rs.getString("viewing_rating"));
				dto.setDirector(rs.getString("director"));
				dto.setCast(rs.getString("cast"));
				dto.setBookingRate(rs.getDouble("booking_rate"));
				dto.setReleaseDate(rs.getDate("release_date"));
				dto.setGenre(rs.getString("genre"));
				dto.setMovieDescription(rs.getString("movie_description"));
				dto.setRating(rs.getDouble("rating"));
				dto.setEndDate(rs.getDate("end_date"));
				dto.setCountry(rs.getString("country"));
				//TODO
				// 대표 이미지 추가
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
		}

		return list;
	}


}
