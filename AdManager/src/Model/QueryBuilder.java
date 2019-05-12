/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Tyler
 */
public class QueryBuilder {
        public String[] columns = new String[10];
        public int num_cols = 0;

        public String[] conditions = new String[10];
        public int num_conds = 0;

        public Object[] args = new Object[10];
        public int num_args = 0;
        
        public void setColumns(String[] newColumns, int newSize) {
            columns = new String[newSize];
            for (int i = 0; i < newSize; i++)
                columns[num_cols++] = new String(newColumns[i]);
        }
        
        private String buildColumns() {
            String selected = "";
            if (num_cols < 1)
                return selected;
            selected += "SELECT ";
            for(int i = 0; i < num_cols; i++) {
                if(i > 0)
                    selected += ", ";
                selected += columns[i];
            }
            selected += " FROM AppView";
            return selected;
        }
        
        public void setCategoryCondition(String category) {
            if (!"All".equals(category)) {
                args[num_args++] = new String(category);
                conditions[num_conds++] = new String("Category=?");
            }
        }

        public void setDateCondition(int months_ago) {
            if (months_ago >= 1) {
                args[num_args++] = new Integer(months_ago);
                conditions[num_conds++] = new String("TIMESTAMPDIFF(MONTH, Date_Posted, CURRENT_TIME())<=?");
            }
        }

        public void setKeywordCondition(String keyword) {
            if (!("".equals(keyword))) {
                args[num_args++] = new String("%" + keyword + "%");
                args[num_args++] = new String("%" + keyword + "%");
                conditions[num_conds++] = new String("Title LIKE ? OR Details LIKE ?");
            }
        }
        
        public void setCondition(String condition) {
            conditions[num_conds++] = new String(condition);
        }
        
        public void setCondition(String condition, Object arg) {
            setArg(arg);
            conditions[num_conds++] = new String(condition);
        }
        
        public void setArg(Object arg) {
            if (arg instanceof String)
                args[num_args++] = new String((String)arg);
            if (arg instanceof Integer)
                args[num_args++] = new Integer((Integer)arg);
        }
        
        private String buildConditions() {
            String filter = "";
            if (num_conds < 1)
                return filter;
            filter += " WHERE ";
            for(int i = 0; i < num_conds; i++) {
                if (i > 0)
                    filter += " AND ";
                filter += "(" + conditions[i] + ")";
            }
            return filter;
        }           
        
        public String buildQuery() {
            return buildColumns() + buildConditions() + ";";
        }
}
