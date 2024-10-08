package example;

import arc.Events;
import arc.util.Log;
import mindustry.content.TechTree;
import mindustry.ctype.UnlockableContent;
import mindustry.game.EventType;
import mindustry.mod.Mod;
import mindustry.ui.dialogs.BaseDialog;

public class ExampleJavaMod extends Mod {
    @SuppressWarnings("unused")
        public ExampleJavaMod() {
                Log.info("[UnlockTechTreeMod] Initializing...");

                        Events.on(EventType.ClientLoadEvent.class, e -> {
                                    BaseDialog dialog = new BaseDialog("Confirmation");
                                                dialog.cont.add("Please confirm that you want to unlock all research on the tech-tree").row();
                                                            dialog.cont.button("Confirm", () -> {
                                                                            dialog.hide();

                                                                                            Log.info("[UnlockTechTreeMod] Unlocking tech-trees...");

                                                                                                            for (TechTree.TechNode node : TechTree.all) {
                                                                                                                                UnlockableContent content = node.content;
                                                                                                                                                    if (content.locked()) {
                                                                                                                                                                            Log.info("[UnlockTechTreeMod] Unlocking content " + (content.name).replace("content", ""));
                                                                                                                                                                                                    content.unlock();
                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                        }

                                                                                                                                                                                                                                                        Log.info("[UnlockTechTreeMod] Successfully unlocked tech-trees");

                                                                                                                                                                                                                                                                        BaseDialog dialog2 = new BaseDialog("Success");
                                                                                                                                                                                                                                                                                        dialog2.cont.add("Successfully unlocked tech-trees").row();
                                                                                                                                                                                                                                                                                                        dialog2.cont.add("Make sure to disable the mod to avoid seeing this dialogue again").row();
                                                                                                                                                                                                                                                                                                                        dialog2.cont.button("Ok", dialog2::hide).size(150F, 50F);
                                                                                                                                                                                                                                                                                                                                        dialog2.show();
                                                                                                                                                                                                                                                                                                                                                    }).size(150F, 50F).row();

                                                                                                                                                                                                                                                                                                                                                                dialog.cont.button("Cancel", () -> {
                                                                                                                                                                                                                                                                                                                                                                                dialog.hide();

                                                                                                                                                                                                                                                                                                                                                                                                BaseDialog dialog2 = new BaseDialog("Cancelled");
                                                                                                                                                                                                                                                                                                                                                                                                                dialog2.cont.add("Cancelled unlocking tech-trees").row();
                                                                                                                                                                                                                                                                                                                                                                                                                                dialog2.cont.add("Disable the mod if you do not want to see this dialogue again").row();
                                                                                                                                                                                                                                                                                                                                                                                                                                                dialog2.cont.button("Ok", dialog2::hide).size(150F, 50F);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                dialog2.show();
                                                                                                                                                                                                                                                                                                                                                                                                                                                                            }).size(150F, 50F);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        dialog.show();
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                });
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    }
