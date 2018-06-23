public class Question640{
    public String solveEquation(String equation) {
        String[] es = equation.split("=");
        Term t1 = getTerm(es[0]);
        Term t2 = getTerm(es[1]);
        Term t3 = new Term(t1.x - t2.x, t1.value - t2.value);
        if (t3.x == 0) {
            if (t3.value == 0) return "Infinite solutions";
            else return "No solution";
        } else {
            if (t3.x < 0) return "x=" + (t3.value / Math.abs(t3.x));
            else return "x=" + (t3.value * -1 / t3.x);
        }
    }

    private Term getTerm(String s) {
        if (s.charAt(0) == '-') s = 0 + s;
        String[] ss = s.split("\\+");
        int x = 0;
        int value = 0;
        for (String x1 : ss) {
            String[] xs = x1.split("-");
            if (xs.length == 1) {
                if (xs[0].charAt(xs[0].length() - 1) == 'x') x += xs[0].length() == 1 ? 1 : Integer
                    .parseInt(xs[0].substring(0, xs[0].length() - 1));
                else value += Integer.parseInt(xs[0]);
            } else {
                if (xs[0].charAt(xs[0].length() - 1) == 'x') x += xs[0].length() == 1 ? 1 : Integer
                    .parseInt(xs[0].substring(0, xs[0].length() - 1));
                else value += Integer.parseInt(xs[0]);

                for (int i = 1; i < xs.length; i++) {
                    if (xs[i].charAt(xs[i].length() - 1) == 'x')
                        x -= xs[i].length() == 1 ? 1 : Integer
                            .parseInt(xs[i].substring(0, xs[i].length() - 1));
                    else value -= Integer.parseInt(xs[i]);
                }
            }
        }
        return new Term(x, value);
    }

    class Term {

        int x;
        int value;

        public Term(int a, int b) {
            x = a;
            value = b;
        }
    }>)}}}>)}}
}
