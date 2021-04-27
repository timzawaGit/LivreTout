package fr.doranco.livretout.utils;

	import java.text.SimpleDateFormat;

	public final class Dates {

		private Dates() {
		}
		private static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		
		public static final java.util.Date stringToDate(String dateStr) throws java.text.ParseException {
			
			return formatter.parse(dateStr);
		}
		
		public static final String dateToString(java.util.Date date) {
			return formatter.format(date);
		}
		
		public static final java.util.Date dateSqlToDateUtil(java.sql.Date sqlDate) {
			if (sqlDate != null)
				return new java.util.Date(sqlDate.getTime());
			return null;
		}
		
		public static final java.sql.Date dateUtilToDateSql(java.util.Date utilDate) {
			if (utilDate != null)
				return new java.sql.Date(utilDate.getTime());
			return null;
		}

}


