package facebook;

public class ReadCharacterRead4_2 {
    private int tmp_index = 0;
    private int tmp_count = 0;
    private char[] tmp = new char[4];
    public int read(char[] buf, int n) {
        int ptr = 0;
        while(ptr < n) {
            if(tmp_index == 0){
                tmp_count = read4(tmp);
            }
            if(tmp_count == 0) break;

            while(ptr < n && tmp_index < tmp_count) {
                buf[ptr++] = tmp[tmp_index++];
            }
            if(tmp_index >= tmp_count) tmp_index = 0;
        }

        return ptr;
    }
}
