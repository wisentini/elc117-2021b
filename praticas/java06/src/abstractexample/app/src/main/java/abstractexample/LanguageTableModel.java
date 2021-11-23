package abstractexample;

import java.util.List;
import javax.swing.table.AbstractTableModel;


class LanguageTableModel extends AbstractTableModel {

  // Lista de linguagens
  private List<Language> languages;

  // Array com os nomes das colunas da tabela
  private static final String[] columnNames = { "languageId", "firstAppeared", "paradigm", "userId" };

  public LanguageTableModel(List<Language> languages) {
    this.languages = languages;
  }

  @Override
  public int getColumnCount() {
    return columnNames.length;
  }

  @Override
  public int getRowCount() {
    return languages.size();
  }

  @Override
  public String getColumnName(int columnIndex) {
    return columnNames[columnIndex];
  }

  @Override
  public Object getValueAt(int rowIndex, int columnIndex) {
    Language row = languages.get(rowIndex);
    switch (columnIndex) {
      case 0: return row.getLanguageId();
      case 1: return row.getFirstAppeared();
      case 2: return row.getParadigm();
      case 3: return row.getUserId();
    }
    return null;
  }

  @Override
  public void setValueAt(Object value, int rowIndex, int columnIndex) {
    Language row = languages.get(rowIndex);
    switch (columnIndex) {
      case 0: row.setLanguageId((String) value); break;
      case 1: row.setFirstAppeared((String) value); break;
      case 2: row.setParadigm((String) value); break;
      case 3: row.setUserId((String) value); break;
    }
  }

  public boolean isCellEditable(int rowIndex, int columnIndex) {
    return true;
  }
  // @Override
  // public Class<?> getColumnClass(int columnIndex) {
  //     return String.class;
  // }

  // Metodo que pode ser chamado pela GUI para remover um elemento
  public void remove(int index) {
    languages.remove(index);
    fireTableRowsDeleted(index, index);
  }

  // Metodo que pode ser chamado pela GUI para selecionar um elemento
  public Language select(int index) {
    return languages.get(index);
  }

  // Metodo que pode ser chamado pela GUI para inserir um elemento
  public void add(Language lang) {
    languages.add(lang);
    fireTableRowsInserted(languages.size()-1, languages.size()-1);
  }

  // Metodo que pode ser chamado pela GUI para alterar um elemento
  public void update(int index, Language lang) {
    languages.set(index, lang);
    fireTableRowsUpdated(index, index);
  }

  

}
