//input: k x k 2D Array a[], bigest k level
//output: optimal path value

int number_triangle(int a[][MAX], int k ){
    int best[MAX][MAX] ={0,};
    int i,j;
    int max_result=0;

    for (i=1;i<=k;i++)
        for (j=1;j<=k;j++) //#define max(a,b) (((a)>(b))?(a):(b))
            best[i][j] = a[i][j] + max(best[i-1][j-1], best[i-1][j]);
    for(i=1;i<=k;i++)
        if(max_result<best[k][i]) max_result =best[k][i];
    return max_result;
}
