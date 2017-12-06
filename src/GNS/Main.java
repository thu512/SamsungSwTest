package GNS;

        import java.io.BufferedReader;
        import java.io.InputStreamReader;
        import java.util.StringTokenizer;

public class Main {
    static String[] m={"ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"};

    public static void main(String args[]) throws Exception	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int[] arr = new int[10];

        int T = Integer.parseInt(str.nextToken());

        for(int test_case = 0; test_case < T; test_case++) {
            str = new StringTokenizer(br.readLine());
            str.nextToken();
            int n = Integer.parseInt(str.nextToken());

            str = new StringTokenizer(br.readLine());
            for (int i = 0; i <n ; i++) {
                String num = str.nextToken();
                switch (num){
                    case "ZRO":
                        arr[0]++;
                        break;
                    case "ONE":
                        arr[1]++;
                        break;
                    case "TWO":
                        arr[2]++;
                        break;
                    case "THR":
                        arr[3]++;
                        break;
                    case "FOR":
                        arr[4]++;
                        break;
                    case "FIV":
                        arr[5]++;
                        break;
                    case "SIX":
                        arr[6]++;
                        break;
                    case "SVN":
                        arr[7]++;
                        break;
                    case "EGT":
                        arr[8]++;
                        break;
                    case "NIN":
                        arr[9]++;
                        break;

                }
            }
            System.out.println("#"+(test_case+1));
            for (int i = 0; i <10 ; i++) {
                for (int j = 0; j <arr[i] ; j++) {
                    System.out.print(m[i]+" ");
                }
            }
        }
    }
}
