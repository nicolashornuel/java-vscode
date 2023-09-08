	private static String getLotsByPropertyToString(final ConsultationFacade entity, final Function<Prestation, String> getProperty) {
		return entity.getListeLotsSansPetitLot().stream()
				.filter(lot ->
						(lot != null) &&
						(lot.getCode() != null))
				.map(lot -> Pair.of(
						lot.getCode(),
						getProperty.apply(lot)))
				.filter(pair -> !pair.get_2().isEmpty())
				.collect(
						Collectors.groupingBy(Pair::get_2,
								Collectors.mapping(Pair::get_1,
										Collectors.joining(COMA))))
				.entrySet().stream()
				.sorted(Map.Entry.comparingByValue())
				.map(e -> {
						final StringBuilder sb = new StringBuilder();
						sb.append(e.getValue().contains(COMA) ? LOTS : LOT);
						sb.append(e.getValue());
						sb.append(DOUBLEDOT);
						sb.append(e.getKey());
						return sb.toString();
				})
				.collect(Collectors.joining(COMA.concat(BREAKLINE), BY_LOT.concat(BREAKLINE), DOT)); // joining(DELIMITER, START, END)
	}