
class CanPlacesFlower {
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        boolean m = true;
        if(flowerbed.length==1)
        {
            if(flowerbed[0]==0)
            {
                count++;
            }
        }
        else {
            if (flowerbed[0] == 0) {
                for (int i = 1; i < flowerbed.length - 1; i++) {
                    if (flowerbed[i] == 0) {
                        if (flowerbed[i - 1] != 1 && flowerbed[i + 1] != 1) {
                            flowerbed[i] = 1;
                            count++;
                        }
                    }
                }
            } else {
                for (int i = 1; i < flowerbed.length - 1; i++) {
                    if (flowerbed[i] == 0) {
                        if (flowerbed[i - 1] != 1 && flowerbed[i + 1] != 1) {
                            flowerbed[i] = 1;
                            count++;
                        }
                    }
                }
            }
            if (flowerbed[0] == 0 && flowerbed[1] == 0) {
                flowerbed[0] = 1;
                count++;
            }
            if (flowerbed[flowerbed.length - 1] == 0 && flowerbed[flowerbed.length - 2] == 0) {
                flowerbed[flowerbed.length - 1] = 1;
                count++;
            }
        }
        System.out.println(count);
        if (count != n && n>count) {
            m = false;
        }
        return m;
    }
        public static void main(String []args){
            int[] arr = {0,0,1,0,0};
            int n = 1;
            boolean bool=canPlaceFlowers(arr, n);
            System.out.println(bool);
        }
    }

