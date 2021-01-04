package usaco;

public class rabinkarp {
	public static void main(String[] args){
		search(new String("Hello Hello"),new String("Hello"),101);
	}
	public static int rabinkarp(String s, String m){
		int sh = 0;
		int mh = 0;
		int d = 256;
		int q = 101;
		int count = 0;
		int h = 0;
		for(int i = 0;i<m.length()-1;i++){
			h = (h*d)%q;
		}
		for(int i = 0;i<m.length();i++){
			mh+=((d*mh)+m.charAt(i))%q;
		}
		for(int i = 0;i<m.length();i++){
			sh+=((d*sh)+s.charAt(i))%q;
		}
		int j =0;
		for(int i = 0;i<=s.length()-m.length();i++){
			if(mh==sh){
				for ( j = 0; j < m.length(); j++) 
                { 
                    if (s.charAt(i+j) != m.charAt(j)) 
                        break; 
                } 
				if(j==m.length()){
					count++;
				}
      
			}
			if(i<s.length()-m.length()){
				sh = (int) ((d*(sh - s.charAt(i)*h) + s.charAt(i+m.length()))%q);
			}
			if (sh < 0) 
                sh = (sh + q); 
		}
		return count;
	}
	 static void search(String pat, String txt, int q) 
	    { 
	        int M = pat.length(); 
	        int N = txt.length(); 
	        int i, j; 
	        int p = 0; // hash value for pattern 
	        int t = 0; // hash value for txt 
	        int h = 1; 
	      
	        // The value of h would be "pow(d, M-1)%q" 
	        for (i = 0; i < M-1; i++) 
	            h = (h*256)%q; 
	      
	        // Calculate the hash value of pattern and first 
	        // window of text 
	        for (i = 0; i < M; i++) 
	        { 
	            p = (256*p + pat.charAt(i))%q; 
	            t = (256*t + txt.charAt(i))%q; 
	        } 
	      
	        // Slide the pattern over text one by one 
	        for (i = 0; i <= N - M; i++) 
	        { 
	      
	            // Check the hash values of current window of text 
	            // and pattern. If the hash values match then only 
	            // check for characters on by one 
	            if ( p == t ) 
	            { 
	                /* Check for characters one by one */
	                for (j = 0; j < M; j++) 
	                { 
	                    if (txt.charAt(i+j) != pat.charAt(j)) 
	                        break; 
	                } 
	      
	                // if p == t and pat[0...M-1] = txt[i, i+1, ...i+M-1] 
	                if (j == M) 
	                    System.out.println("Pattern found at index " + i); 
	            } 
	      
	            // Calculate hash value for next window of text: Remove 
	            // leading digit, add trailing digit 
	            if ( i < N-M ) 
	            { 
	                t = (256*(t - txt.charAt(i)*h) + txt.charAt(i+M))%q; 
	      
	                // We might get negative value of t, converting it 
	                // to positive 
	                if (t < 0) 
	                t = (t + q); 
	            } 
	        } 
	    } 
	
}
