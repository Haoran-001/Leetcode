package top.zhouhaoran.leetcode;

public class Search4 {
    public static void main(String[] args) {
        Search4 search = new Search4();
        int[] arr = {5,5,5,1,2,3,4,5};
        int target = 5;
//        int[] arr = {1,1,1,1,1,2,1,1,1};
//        int target = 2;

        System.out.println(search.search2(arr, target));
        System.out.println(search.getRotationMatrixMin(new int[] {1, 1, 2, 1, 1}));
    }

    // 3 4 5 1 2 3
    //
    public int search(int[] arr, int target) {
        int n = arr.length;

        if (n == 0) {
            return -1;
        }
        // 使用二分查找，找到旋转数组中的最小值
        int left = 0, right = n - 1;

        while (right >= 0 && arr[left] == arr[right]) right--;

        if (arr[left] > arr[right]) {
            while (left < right) {
                int mid = (right - left) / 2 + left;
                if (arr[mid] > arr[0]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
        }


        /** 2.判断target所在的区间 */
        if(left==right){
            if(target>=arr[0]){
                left=0;
                right--;
            }else{
                right=n-1;
            }
        }
        /** 3.搜索target */
        while(right>=0&&left<right){
            int mid=left+(right-left)/2;
            if(arr[mid]==target){
                right=mid;
            }else if(arr[mid]<target){
                left=mid+1;
            }else{
                right=mid;
            }
        }

        return arr[right]==target?right:-1;
    }

    public int getRotationMatrixMin(int[] arr) {
        int left = 0, right = arr.length - 1;

        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (arr[mid] >= arr[0]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    public int search2(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        // 针对1 1 2 1 1这种情况会找到最小值的下标最后一个，但显然不正确，左区间为1 1 2 1，右区间为1
        // 针对2 2 3 1 1这种情况并不出现此错误，最小值是倒数第二个1, 也就是左区间为2 2 3，右区间为1 1
        // 而我们针对1 1 2 1 1需要将后面区间1 1,直接使用1 1 2区间查找
        int left = 0, right = arr.length - 1;
        while (left < right && arr[left] == arr[right]) right--;

        // 找到旋转数组中最小的数
        if (arr[0] > arr[right]) {
            while (left < right) {
                int mid = (right - left) / 2 + left;
                if (arr[mid] >= arr[0]) {
                    left = mid + 1;
                } else if (arr[mid] < arr[0]) {
                    right = mid;
                }
            }
        }

        // 判断target是在左区间还是右区间,其前提是找到了旋转数组最小值的情况,
        // 1 1 2 1 1 这种情况变为1 1 2，则left!=right，不需要判断，直接在1 1 2中进行二分查找即可
        if (left == right) {
            if (target >= arr[0]) {
                left = 0;
                right--;
            } else {
                right = arr.length - 1;
            }
        }


        // 在对应的区间内进行查找
        // 不能使用left = right然后mid下标值为target就返回这种常规的二分查找方法
        // eg. 2 2 2 left=0, right = 2, target = 2, arr[mid] = 2, 直接返回mid下标1, 而我们想要的是下标0
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (arr[mid] == target) {
                right = mid;
            } else if (target < arr[mid]) {
                right = mid;
            } else if (target > arr[mid]) {
                left = mid + 1;
            }
        }

        return arr[right] == target ? right : -1;
    }
}
