class Solution {
public:
    vector<vector<int>> groupThePeople(vector<int>& groupSizes) {
        vector<vector<int>> ans;
        int i,j,n;
        n=groupSizes.size();
        for ( i=1;i<=*max_element(groupSizes.begin(),groupSizes.end());i++ ) {
            vector<int> temp;
                for ( j=0;j<n;j++ ) {
                    
                    if ( i==groupSizes[j] ) {
                        if (temp.size()>=i) {
                            ans.push_back(temp);
                            temp.clear();
                        }
                        temp.push_back(j);
                    }
                }
            if (temp.size()>=1) {
                ans.push_back(temp);
                temp.clear();
            }
        }
        return ans;
    }
};