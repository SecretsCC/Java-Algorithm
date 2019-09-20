package facebook;

public class ReadNCharacterRead4 {
    public int read(char[] buf, int n) {
        char[] tmp = new char[4];
        int index_buf = 0;
        int index_tmp = 0;
        while(index_buf < n) {
            int len = read4(tmp);
            index_tmp = 0;
            while(index_buf < n && index_tmp < len) {
                buf[index_buf++] = tmp[index_tmp++];
            }
            if(len < 4) break;
        }
        return index_buf;
    }
}
