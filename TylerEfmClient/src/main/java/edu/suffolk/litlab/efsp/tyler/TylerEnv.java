package edu.suffolk.litlab.efsp.tyler;

/** The type of server environents that Tyler owns themselves. */
public enum TylerEnv {
  /// i.e. the production / live environment
  PROD,
  /// should be "identical" to PROD
  TEST,
  /// to "deploy patches and new releases prior to introduction into" PROD
  STAGE;
}
