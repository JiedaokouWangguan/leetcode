public class Question178{
    /*
       SELECT
       Score,
       (SELECT count(distinct Score) FROM Scores WHERE Score >= s.Score) Rank
       FROM Scores s
       ORDER BY Score desc)
       */
}
