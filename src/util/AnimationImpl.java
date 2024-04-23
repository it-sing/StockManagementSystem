package util;

import static java.lang.System.out;

public class AnimationImpl implements Animation{
    @Override
    public void loadData() {
        try {
            String[] animationChars = { ".", "..", "...", "...." };
            String[] animationDots = { "|", "/", "-", "\\" };
            int timesToRepeat = 10;

            out.println("#".repeat(25));
            for (int i = 0; i < timesToRepeat; i++) {
                out.print("\rData is Loading " + animationDots[i % animationDots.length] + animationChars[i % animationChars.length]);
                try {

                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    out.println(e.getMessage());
                }
            }
            out.print("\rData is Loading \n");
            out.println("#".repeat(25));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
